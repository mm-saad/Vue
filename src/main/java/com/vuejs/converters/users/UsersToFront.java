package com.vuejs.converters.users;

import com.vuejs.domain.users.Users;
import com.vuejs.dto.users.UsersDescription;

import java.util.ArrayList;
import java.util.List;

public class UsersToFront {

    public UsersToFront(){
    }

    public Users convert (UsersDescription dto){
        Users domain = new Users();
        domain.setId(dto.getId());
        domain.setVersion(dto.getVersion());
        domain.setFirstName(dto.getFirstName());
        domain.setLastName(dto.getLastName());
        domain.setAdresse(dto.getAdresse());
        domain.setEmail(dto.getEmail());
        return domain;
    }

    public List<Users> convert(List<UsersDescription> sourceList) {
        List<Users> listUsers = new ArrayList<>();
        for (UsersDescription usersDescription : sourceList) {
            listUsers.add(convert(usersDescription));
        }
        return listUsers;
    }


}
