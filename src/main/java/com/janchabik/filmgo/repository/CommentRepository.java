package com.janchabik.filmgo.repository;

import com.janchabik.filmgo.domain.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Comment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select comment from Comment comment where comment.user.login = ?#{principal.username}")
    List<Comment> findByUserIsCurrentUser();

    List<Comment> findByReviewId(Long id);
}
