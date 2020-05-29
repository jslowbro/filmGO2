package com.mycompany.filmgo.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.filmgo.web.rest.TestUtil;

public class FilmDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FilmDTO.class);
        FilmDTO filmDTO1 = new FilmDTO();
        filmDTO1.setId(1L);
        FilmDTO filmDTO2 = new FilmDTO();
        assertThat(filmDTO1).isNotEqualTo(filmDTO2);
        filmDTO2.setId(filmDTO1.getId());
        assertThat(filmDTO1).isEqualTo(filmDTO2);
        filmDTO2.setId(2L);
        assertThat(filmDTO1).isNotEqualTo(filmDTO2);
        filmDTO1.setId(null);
        assertThat(filmDTO1).isNotEqualTo(filmDTO2);
    }
}
