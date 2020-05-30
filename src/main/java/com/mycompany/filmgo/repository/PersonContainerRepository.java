package com.mycompany.filmgo.repository;

import com.mycompany.filmgo.domain.PersonContainer;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PersonContainer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PersonContainerRepository extends JpaRepository<PersonContainer, Long> {
}
