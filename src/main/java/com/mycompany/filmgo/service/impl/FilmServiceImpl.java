package com.mycompany.filmgo.service.impl;

import com.mycompany.filmgo.domain.Film;
import com.mycompany.filmgo.domain.Rating;
import com.mycompany.filmgo.domain.Review;
import com.mycompany.filmgo.repository.FilmRepository;
import com.mycompany.filmgo.repository.RatingRepository;
import com.mycompany.filmgo.repository.ReviewRepository;
import com.mycompany.filmgo.service.FilmService;
import com.mycompany.filmgo.service.dto.FilmDTO;
import com.mycompany.filmgo.service.dto.FilmWithRatingsDTO;
import com.mycompany.filmgo.service.mapper.FilmMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Film}.
 */
@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    private final Logger log = LoggerFactory.getLogger(FilmServiceImpl.class);

    private final FilmRepository filmRepository;
    private final RatingRepository ratingRepository;
    private final ReviewRepository reviewRepository;

    private final FilmMapper filmMapper;

    public FilmServiceImpl(
        FilmRepository filmRepository,
        RatingRepository ratingRepository,
        ReviewRepository reviewRepository,
        FilmMapper filmMapper
    ) {
        this.filmRepository = filmRepository;
        this.ratingRepository = ratingRepository;
        this.reviewRepository = reviewRepository;
        this.filmMapper = filmMapper;
    }

    /**
     * Save a film.
     *
     * @param filmDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public FilmDTO save(FilmDTO filmDTO) {
        log.debug("Request to save Film : {}", filmDTO);
        Film film = filmMapper.toEntity(filmDTO);
        film = filmRepository.save(film);
        return filmMapper.toDto(film);
    }

    /**
     * Get all the films.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<FilmDTO> findAll() {
        log.debug("Request to get all Films");
        return filmRepository.findAll().stream().map(filmMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one film by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<FilmDTO> findOne(Long id) {
        log.debug("Request to get Film : {}", id);
        return filmRepository.findById(id).map(filmMapper::toDto);
    }

    /**
     * Delete the film by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Film : {}", id);

        filmRepository.deleteById(id);
    }

    @Override
    public Optional<FilmWithRatingsDTO> findOneWithRatings(Long id) {
        Optional<Film> film = filmRepository.findById(id);
        if (film.isPresent()) {
            Double audienceRating = getAudienceRating(id);
            Double criticsRating = getCriticsRating(id);
            return Optional.of(
                new FilmWithRatingsDTO(
                    film.get().getId(),
                    film.get().getTitle(),
                    film.get().getDescription(),
                    film.get().getReleaseDate(),
                    audienceRating,
                    criticsRating
                )
            );
        } else {
            return Optional.empty();
        }
    }

    private Double getAudienceRating(Long filmId) {
        OptionalDouble audienceRating = ratingRepository.findByFilmId(filmId).stream().mapToInt(Rating::getValue).average();
        return audienceRating.isPresent() ? audienceRating.getAsDouble() : 0;
    }

    private Double getCriticsRating(Long filmId) {
        OptionalDouble criticsRating = reviewRepository.findByFilmId(filmId).stream().mapToInt(Review::getValue).average();
        return criticsRating.isPresent() ? criticsRating.getAsDouble() : 0;
    }
}
