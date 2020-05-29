package com.mycompany.filmgo.service.dto;

import java.io.Serializable;
import com.mycompany.filmgo.domain.enumeration.Role;

/**
 * A DTO for the {@link com.mycompany.filmgo.domain.PersonContainer} entity.
 */
public class PersonContainerDTO implements Serializable {
    
    private Long id;

    private Role role;


    private Long personId;

    private Long filmId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonContainerDTO)) {
            return false;
        }

        return id != null && id.equals(((PersonContainerDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PersonContainerDTO{" +
            "id=" + getId() +
            ", role='" + getRole() + "'" +
            ", personId=" + getPersonId() +
            ", filmId=" + getFilmId() +
            "}";
    }
}
