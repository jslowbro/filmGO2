package com.janchabik.filmgo.repository;

import com.janchabik.filmgo.domain.Review;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Review entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select review from Review review where review.user.login = ?#{principal.username}")
    List<Review> findByUserIsCurrentUser();

    List<Review> findByFilmId(Long id);
}
