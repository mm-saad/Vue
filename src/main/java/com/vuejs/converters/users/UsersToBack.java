package com.vuejs.converters.users;

import com.vuejs.domain.users.Users;
import com.vuejs.dto.users.UsersDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NBE3663 on 27/06/2017.
 */
public class UsersToBack {

    public UsersToBack() {
    }

    public UsersDescription convert(Users source) {
        UsersDescription dto = new UsersDescription();
        dto.setId(source.getId());
        dto.setVersion(source.getVersion());
        dto.setFirstName(source.getFirstName());
        dto.setLastName(source.getLastName());
        dto.setEmail(source.getEmail());
        dto.setAdresse(source.getAdresse());
        return dto;
    }

    public List<UsersDescription> convert(List<Users> sourceList) {
        List<UsersDescription> listDto = new ArrayList<>();
        for (Users users : sourceList) {
            listDto.add(convert(users));
        }
        return listDto;
    }

}
