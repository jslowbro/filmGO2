package com.janchabik.filmgo.service.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonContainerMapperTest {

    private PersonContainerMapper personContainerMapper;

    @BeforeEach
    public void setUp() {
        personContainerMapper = new PersonContainerMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        Assertions.assertThat(personContainerMapper.fromId(id).getId()).isEqualTo(id);
        Assertions.assertThat(personContainerMapper.fromId(null)).isNull();
    }
}
