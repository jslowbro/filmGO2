package com.janchabik.filmgo.service.dto;

import com.janchabik.filmgo.domain.Review;

import java.io.Serializable;
import javax.persistence.Lob;

/**
 * A DTO for the {@link Review} entity.
 */
public class ReviewDTO implements Serializable {
    private Long id;

    @Lob
    private String text;

    private String title;

    private Integer value;

    private Long filmId;

    private Long userId;

    private String userLogin;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReviewDTO)) {
            return false;
        }

        return id != null && id.equals(((ReviewDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore

    @Override
    public String toString() {
        return "ReviewDTO{" +
            "id=" + id +
            ", text='" + text + '\'' +
            ", title='" + title + '\'' +
            ", value=" + value +
            ", filmId=" + filmId +
            ", userId=" + userId +
            ", userLogin='" + userLogin + '\'' +
            '}';
    }
}
