package com.mycompany.filmgo.repository;

import com.mycompany.filmgo.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Film entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {}
