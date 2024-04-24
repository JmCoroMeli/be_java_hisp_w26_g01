package com.javabootcamp.socialmeli.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.javabootcamp.socialmeli.model.User;

@Repository
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
