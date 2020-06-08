package com.janchabik.filmgo.service.mapper;


import com.janchabik.filmgo.domain.Comment;
import com.janchabik.filmgo.service.dto.CommentDTO;
import com.mycompany.filmgo.domain.*;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Comment} and its DTO {@link CommentDTO}.
 */
@Mapper(componentModel = "spring", uses = {ReviewMapper.class, UserMapper.class})
public interface CommentMapper extends EntityMapper<CommentDTO, Comment> {

    @Mapping(source = "review.id", target = "reviewId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.login", target = "userLogin")
    CommentDTO toDto(Comment comment);

    @Mapping(source = "reviewId", target = "review")
    @Mapping(source = "userId", target = "user")
    Comment toEntity(CommentDTO commentDTO);

    default Comment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setId(id);
        return comment;
    }
}
