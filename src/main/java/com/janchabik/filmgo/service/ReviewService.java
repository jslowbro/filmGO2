package com.janchabik.filmgo.service;

import com.janchabik.filmgo.domain.Review;
import com.janchabik.filmgo.service.dto.ReviewDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Review}.
 */
public interface ReviewService {
    /**
     * Save a review.
     *
     * @param reviewDTO the entity to save.
     * @return the persisted entity.
     */
    ReviewDTO save(ReviewDTO reviewDTO);

    /**
     * Get all the reviews.
     *
     * @return the list of entities.
     */
    List<ReviewDTO> findAll();

    /**
     * Get the "id" review.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReviewDTO> findOne(Long id);

    /**
     * Delete the "id" review.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<ReviewDTO> findByFilmId(Long id);
}
