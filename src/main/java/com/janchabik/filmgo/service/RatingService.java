package com.janchabik.filmgo.service;

import com.janchabik.filmgo.domain.Rating;
import com.janchabik.filmgo.service.dto.RatingDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Rating}.
 */
public interface RatingService {

    /**
     * Save a rating.
     *
     * @param ratingDTO the entity to save.
     * @return the persisted entity.
     */
    RatingDTO save(RatingDTO ratingDTO);

    /**
     * Get all the ratings.
     *
     * @return the list of entities.
     */
    List<RatingDTO> findAll();


    /**
     * Get the "id" rating.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RatingDTO> findOne(Long id);

    /**
     * Delete the "id" rating.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
