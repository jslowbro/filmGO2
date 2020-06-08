package com.janchabik.filmgo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

import com.janchabik.filmgo.domain.enumeration.Role;

/**
 * A PersonContainer.
 */
@Entity
@Table(name = "person_container")
public class PersonContainer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @ManyToOne
    @JsonIgnoreProperties(value = "personContainers", allowSetters = true)
    private Person person;

    @ManyToOne
    @JsonIgnoreProperties(value = "personContainers", allowSetters = true)
    private Film film;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public PersonContainer role(Role role) {
        this.role = role;
        return this;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public PersonContainer person(Person person) {
        this.person = person;
        return this;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Film getFilm() {
        return film;
    }

    public PersonContainer film(Film film) {
        this.film = film;
        return this;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonContainer)) {
            return false;
        }
        return id != null && id.equals(((PersonContainer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PersonContainer{" +
            "id=" + getId() +
            ", role='" + getRole() + "'" +
            "}";
    }
}
