package com.janchabik.filmgo.service.impl;

import com.janchabik.filmgo.domain.Review;
import com.janchabik.filmgo.repository.ReviewRepository;
import com.janchabik.filmgo.service.ReviewService;
import com.janchabik.filmgo.domain.User;
import com.janchabik.filmgo.service.UserService;
import com.janchabik.filmgo.service.dto.ReviewDTO;
import com.janchabik.filmgo.service.mapper.ReviewMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Review}.
 */
@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
    private final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    private final UserService userService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
        this.userService = userService;
    }

    /**
     * Save a review.
     *
     * @param reviewDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ReviewDTO save(ReviewDTO reviewDTO) {
        if (reviewDTO.getUserId() == null && reviewDTO.getUserLogin() != null) {
            Optional<User> user = userService.getUserWithAuthoritiesByLogin(reviewDTO.getUserLogin());
            if (user.isPresent()) {
                reviewDTO.setUserId(user.get().getId());
            }
        }
        log.debug("Request to save Review : {}", reviewDTO);
        Review review = reviewMapper.toEntity(reviewDTO);
        review = reviewRepository.save(review);
        return reviewMapper.toDto(review);
    }

    /**
     * Get all the reviews.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReviewDTO> findAll() {
        log.debug("Request to get all Reviews");
        return reviewRepository.findAll().stream().map(reviewMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one review by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReviewDTO> findOne(Long id) {
        log.debug("Request to get Review : {}", id);
        return reviewRepository.findById(id).map(reviewMapper::toDto);
    }

    /**
     * Delete the review by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Review : {}", id);

        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDTO> findByFilmId(Long id) {
        return reviewRepository.findByFilmId(id).stream().map(reviewMapper::toDto).collect(Collectors.toList());
    }
}
