package com.janchabik.filmgo.service.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonMapperTest {

    private PersonMapper personMapper;

    @BeforeEach
    public void setUp() {
        personMapper = new PersonMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        Assertions.assertThat(personMapper.fromId(id).getId()).isEqualTo(id);
        Assertions.assertThat(personMapper.fromId(null)).isNull();
    }
}
