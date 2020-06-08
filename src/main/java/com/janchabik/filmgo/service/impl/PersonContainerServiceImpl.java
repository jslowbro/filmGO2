package com.janchabik.filmgo.service.impl;

import com.janchabik.filmgo.domain.PersonContainer;
import com.janchabik.filmgo.domain.enumeration.Role;
import com.janchabik.filmgo.repository.PersonContainerRepository;
import com.janchabik.filmgo.service.PersonContainerService;
import com.janchabik.filmgo.service.PersonService;
import com.janchabik.filmgo.service.dto.RoleListDTO;
import com.janchabik.filmgo.service.dto.PersonContainerDTO;
import com.janchabik.filmgo.service.mapper.PersonContainerMapper;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PersonContainer}.
 */
@Service
@Transactional
public class PersonContainerServiceImpl implements PersonContainerService {
    private final Logger log = LoggerFactory.getLogger(PersonContainerServiceImpl.class);

    private final PersonContainerRepository personContainerRepository;

    private final PersonContainerMapper personContainerMapper;

    private final PersonService personService;

    public PersonContainerServiceImpl(
        PersonContainerRepository personContainerRepository,
        PersonContainerMapper personContainerMapper,
        PersonService personService
    ) {
        this.personContainerRepository = personContainerRepository;
        this.personContainerMapper = personContainerMapper;
        this.personService = personService;
    }

    /**
     * Save a personContainer.
     *
     * @param personContainerDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public PersonContainerDTO save(PersonContainerDTO personContainerDTO) {
        log.debug("Request to save PersonContainer : {}", personContainerDTO);
        PersonContainer personContainer = personContainerMapper.toEntity(personContainerDTO);
        personContainer = personContainerRepository.save(personContainer);
        return personContainerMapper.toDto(personContainer);
    }

    /**
     * Get all the personContainers.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PersonContainerDTO> findAll() {
        log.debug("Request to get all PersonContainers");
        return personContainerRepository
            .findAll()
            .stream()
            .map(personContainerMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one personContainer by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PersonContainerDTO> findOne(Long id) {
        log.debug("Request to get PersonContainer : {}", id);
        return personContainerRepository.findById(id).map(personContainerMapper::toDto);
    }

    /**
     * Delete the personContainer by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PersonContainer : {}", id);

        personContainerRepository.deleteById(id);
    }

    @Override
    public List<PersonContainerDTO> findByPersonId(Long personId) {
        return personContainerRepository.findByPersonId(personId).stream().map(personContainerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PersonContainerDTO> findByFilmId(Long filmId) {
        return personContainerRepository.findByFilmId(filmId).stream().map(personContainerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PersonContainerDTO> findByPersonIdAndFilmId(Long personId, Long filmId) {
        return personContainerRepository
            .findByFilmIdAndPersonId(filmId, personId)
            .stream()
            .map(personContainerMapper::toDto)
            .collect(Collectors.toList());
    }

    public List<RoleListDTO> sortByRole(List<PersonContainerDTO> personContainerDTOS) {
        Map<Role, List<PersonContainerDTO>> personContainerDTOMap = new HashMap<>();
        for (PersonContainerDTO containerDTO : personContainerDTOS) {
            putInMap(personContainerDTOMap, containerDTO);
        }
        return mapToRoleListDTOs(personContainerDTOMap);
    }

    private List<RoleListDTO> mapToRoleListDTOs(Map<Role, List<PersonContainerDTO>> personContainerDTOMap) {
        return personContainerDTOMap
            .entrySet()
            .stream()
            .map(
                e ->
                    new RoleListDTO(
                        e.getKey(),
                        e
                            .getValue()
                            .stream()
                            .map(
                                personContainerDTO ->
                                    personService
                                        .findOne(personContainerDTO.getPersonId())
                                        .orElseThrow(
                                            () ->
                                                new IllegalStateException(
                                                    "Person Container " + personContainerDTO.getId() + "point to an inexisting Person"
                                                )
                                        )
                            )
                            .collect(Collectors.toList())
                    )
            )
            .collect(Collectors.toList());
    }

    private void putInMap(Map<Role, List<PersonContainerDTO>> personContainerDTOMap, PersonContainerDTO personContainerDTO) {
        Role role = personContainerDTO.getRole();
        if (personContainerDTOMap.containsKey(role)) {
            List<PersonContainerDTO> existing = personContainerDTOMap.get(role);
            existing.add(personContainerDTO);
            personContainerDTOMap.put(role, existing);
        } else {
            personContainerDTOMap.put(role, Stream.of(personContainerDTO).collect(Collectors.toList()));
        }
    }
}
