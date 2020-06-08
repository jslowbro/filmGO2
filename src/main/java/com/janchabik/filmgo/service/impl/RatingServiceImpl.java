package com.janchabik.filmgo.service.impl;

import com.janchabik.filmgo.domain.Rating;
import com.janchabik.filmgo.repository.RatingRepository;
import com.janchabik.filmgo.service.RatingService;
import com.janchabik.filmgo.domain.User;
import com.janchabik.filmgo.service.UserService;
import com.janchabik.filmgo.service.dto.RatingDTO;
import com.janchabik.filmgo.service.mapper.RatingMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Rating}.
 */
@Service
@Transactional
public class RatingServiceImpl implements RatingService {
    private final Logger log = LoggerFactory.getLogger(RatingServiceImpl.class);

    private final RatingRepository ratingRepository;

    private final RatingMapper ratingMapper;

    private final UserService userService;

    public RatingServiceImpl(RatingRepository ratingRepository, RatingMapper ratingMapper, UserService userService) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
        this.userService = userService;
    }

    /**
     * Save a rating.
     *
     * @param ratingDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public RatingDTO save(RatingDTO ratingDTO) {
        if (ratingDTO.getUserId() == null && ratingDTO.getUserLogin() != null) {
            Optional<User> user = userService.getUserWithAuthoritiesByLogin(ratingDTO.getUserLogin());
            if (user.isPresent()) {
                ratingDTO.setUserId(user.get().getId());
            }
        }
        log.debug("Request to save Rating : {}", ratingDTO);
        Rating rating = ratingMapper.toEntity(ratingDTO);
        rating = ratingRepository.save(rating);
        return ratingMapper.toDto(rating);
    }

    /**
     * Get all the ratings.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<RatingDTO> findAll() {
        log.debug("Request to get all Ratings");
        return ratingRepository.findAll().stream().map(ratingMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one rating by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<RatingDTO> findOne(Long id) {
        log.debug("Request to get Rating : {}", id);
        return ratingRepository.findById(id).map(ratingMapper::toDto);
    }

    /**
     * Delete the rating by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Rating : {}", id);

        ratingRepository.deleteById(id);
    }
}
