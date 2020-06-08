package com.janchabik.filmgo.service.dto;

import java.time.Instant;

public class FilmWithRatingsDTO extends FilmDTO {
    private Double audienceRating;
    private Double criticsRating;

    public FilmWithRatingsDTO(Long id, String title, String description, Instant releaseDate, Double audienceRating, Double criticsRating) {
        super(id, title, description, releaseDate);
        this.audienceRating = audienceRating;
        this.criticsRating = criticsRating;
    }

    public FilmWithRatingsDTO() {}

    public Double getAudienceRating() {
        return audienceRating;
    }

    public void setAudienceRating(Double audienceRating) {
        this.audienceRating = audienceRating;
    }

    public Double getCriticsRating() {
        return criticsRating;
    }

    public void setCriticsRating(Double criticsRating) {
        this.criticsRating = criticsRating;
    }
}
