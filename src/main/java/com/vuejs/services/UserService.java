package com.vuejs.services;

import com.vuejs.models.User;
import com.vuejs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findUser(long id) {

        return repository.findOne(id);
    }

    public Iterable<User> findAllUsers(){
        return repository.findAll();
    }
}
