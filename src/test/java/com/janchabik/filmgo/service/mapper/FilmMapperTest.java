package com.janchabik.filmgo.service.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FilmMapperTest {

    private FilmMapper filmMapper;

    @BeforeEach
    public void setUp() {
        filmMapper = new FilmMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        Assertions.assertThat(filmMapper.fromId(id).getId()).isEqualTo(id);
        Assertions.assertThat(filmMapper.fromId(null)).isNull();
    }
}
