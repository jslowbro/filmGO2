package com.janchabik.filmgo.service;

import com.janchabik.filmgo.domain.PersonContainer;
import com.janchabik.filmgo.service.dto.RoleListDTO;
import com.janchabik.filmgo.service.dto.PersonContainerDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link PersonContainer}.
 */
public interface PersonContainerService {
    /**
     * Save a personContainer.
     *
     * @param personContainerDTO the entity to save.
     * @return the persisted entity.
     */
    PersonContainerDTO save(PersonContainerDTO personContainerDTO);

    /**
     * Get all the personContainers.
     *
     * @return the list of entities.
     */
    List<PersonContainerDTO> findAll();

    /**
     * Get the "id" personContainer.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PersonContainerDTO> findOne(Long id);

    /**
     * Delete the "id" personContainer.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<PersonContainerDTO> findByPersonId(Long personId);

    List<PersonContainerDTO> findByFilmId(Long filmId);

    List<PersonContainerDTO> findByPersonIdAndFilmId(Long personId, Long filmId);

    List<RoleListDTO> sortByRole(List<PersonContainerDTO> personContainerDTOS);
}
