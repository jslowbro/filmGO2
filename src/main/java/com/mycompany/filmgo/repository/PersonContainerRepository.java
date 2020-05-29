package com.mycompany.filmgo.repository;

import com.mycompany.filmgo.domain.PersonContainer;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PersonContainer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PersonContainerRepository extends JpaRepository<PersonContainer, Long> {
    List<PersonContainer> findByPersonId(Long personId);

    List<PersonContainer> findByFilmId(Long filmId);

    List<PersonContainer> findByFilmIdAndPersonId(Long filmId, Long personId);
}
