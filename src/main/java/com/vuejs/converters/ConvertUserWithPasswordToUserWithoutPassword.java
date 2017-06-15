package com.vuejs.converters;

import com.vuejs.models.UserWithPassword;
import com.vuejs.models.UserWithoutPassword;

public class ConvertUserWithPasswordToUserWithoutPassword {

    public UserWithoutPassword convert(UserWithPassword userWithPassword) {

        UserWithoutPassword userWithoutPassword = new UserWithoutPassword();

        userWithoutPassword.setUsername(userWithPassword.getUserName());
        userWithoutPassword.setEmail(userWithPassword.getEmail());

        return userWithoutPassword;
    }
}
