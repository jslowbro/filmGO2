package com.mycompany.filmgo.service;

import com.mycompany.filmgo.service.dto.FilmDTO;
import com.mycompany.filmgo.service.dto.FilmWithRatingsDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.filmgo.domain.Film}.
 */
public interface FilmService {
    /**
     * Save a film.
     *
     * @param filmDTO the entity to save.
     * @return the persisted entity.
     */
    FilmDTO save(FilmDTO filmDTO);

    /**
     * Get all the films.
     *
     * @return the list of entities.
     */
    List<FilmDTO> findAll();

    /**
     * Get the "id" film.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FilmDTO> findOne(Long id);

    /**
     * Delete the "id" film.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Optional<FilmWithRatingsDTO> findOneWithRatings(Long id);

    List<FilmDTO> findByPersonId(Long id);
}
