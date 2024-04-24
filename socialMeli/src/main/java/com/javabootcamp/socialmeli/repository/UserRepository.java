package com.javabootcamp.socialmeli.repository;

import java.util.Optional;

import com.javabootcamp.socialmeli.model.User;

public interface UserRepository {
    Optional<User> findById(Integer id);
}
