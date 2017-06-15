package com.vuejs.controllers;

import com.vuejs.models.User;
import com.vuejs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

//    @RequestMapping(value = "/abcTab", method = RequestMethod.GET)
//    public String[] returnTab() {
//
//        String[] tab = {"a", "b", "c"};
//        return tab;
//    }
//
//    @RequestMapping(value = "/abcMap", method = RequestMethod.GET)
//    public Map<String, String> returnMap() {
//
//        Map<String, String> map = new HashMap<>();
//        map.put("a", "a");
//        map.put("b", "b");
//        map.put("c", "c");
//
//        return map;
//    }
//
//    @RequestMapping(value = "/abcList", method = RequestMethod.GET)
//    public List<String> returnList() {
//
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//
//        return list;
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findUser(@PathVariable long id) {

        return service.findUser(id);
    }
}
