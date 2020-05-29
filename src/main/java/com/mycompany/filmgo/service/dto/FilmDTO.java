package com.mycompany.filmgo.service.dto;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.mycompany.filmgo.domain.Film} entity.
 */
public class FilmDTO implements Serializable {
    private Long id;

    private String title;

    private String description;

    private Instant releaseDate;

    public FilmDTO(Long id, String title, String description, Instant releaseDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public FilmDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FilmDTO)) {
            return false;
        }

        return id != null && id.equals(((FilmDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FilmDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", releaseDate='" + getReleaseDate() + "'" +
            "}";
    }
}
