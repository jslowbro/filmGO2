package com.janchabik.filmgo.repository;

import com.janchabik.filmgo.domain.Rating;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Rating entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("select rating from Rating rating where rating.user.login = ?#{principal.username}")
    List<Rating> findByUserIsCurrentUser();

    List<Rating> findByFilmId(Long id);
}
