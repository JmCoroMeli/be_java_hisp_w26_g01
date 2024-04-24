package com.javabootcamp.socialmeli.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.javabootcamp.socialmeli.model.User;

public class UserRepositoryImpl implements UserRepository{

    private List<User> usersList;

    public UserRepositoryImpl(){
        this.usersList = new ArrayList<>();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return usersList
            .stream()
            .filter(u -> u.getId().equals(id))
            .findFirst();
    }

}
