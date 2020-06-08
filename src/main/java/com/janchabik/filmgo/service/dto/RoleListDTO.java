package com.janchabik.filmgo.service.dto;

import com.janchabik.filmgo.domain.enumeration.Role;
import java.io.Serializable;
import java.util.List;

public class RoleListDTO implements Serializable {
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
