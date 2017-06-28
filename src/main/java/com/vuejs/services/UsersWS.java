package com.vuejs.services;

import com.vuejs.converters.users.UsersToBack;
import com.vuejs.converters.users.UsersToFront;
import com.vuejs.dao.UsersDAO;
import com.vuejs.domain.users.Users;
import com.vuejs.dto.users.UsersDescription;
//import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
public class UsersWS {

    @Inject
    UsersDAO usersDAO;


    @CrossOrigin
    @RequestMapping(value = "${endpoint.addusers}", method = RequestMethod.POST)
    @ResponseBody
    public UsersDescription addUsers(@RequestBody UsersDescription usersDescription){
        Users users = usersDAO.addUsers(
                new UsersToFront().convert(usersDescription));
        return new UsersToBack().convert(users);
    }
}
