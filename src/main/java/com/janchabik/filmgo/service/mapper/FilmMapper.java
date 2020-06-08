package com.janchabik.filmgo.service.mapper;


import com.janchabik.filmgo.domain.Film;
import com.mycompany.filmgo.domain.*;
import com.janchabik.filmgo.service.dto.FilmDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Film} and its DTO {@link FilmDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FilmMapper extends EntityMapper<FilmDTO, Film> {



    default Film fromId(Long id) {
        if (id == null) {
            return null;
        }
        Film film = new Film();
        film.setId(id);
        return film;
    }
}
