package com.mycompany.filmgo.service.dto;

import com.mycompany.filmgo.domain.Person;
import com.mycompany.filmgo.domain.enumeration.Role;
import java.util.List;

public class RoleListDTO {
    private Role role;
    private List<PersonDTO> personList;

    public RoleListDTO(Role role, List<PersonDTO> personList) {
        this.role = role;
        this.personList = personList;
    }

    public RoleListDTO() {}

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<PersonDTO> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonDTO> personList) {
        this.personList = personList;
    }
}
