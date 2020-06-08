package com.janchabik.filmgo.service.mapper;


import com.janchabik.filmgo.domain.Person;
import com.mycompany.filmgo.domain.*;
import com.janchabik.filmgo.service.dto.PersonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Person} and its DTO {@link PersonDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {



    default Person fromId(Long id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }
}
