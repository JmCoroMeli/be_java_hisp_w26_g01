package com.javabootcamp.socialmeli.repository;

import java.util.List;
import java.util.Optional;

import com.javabootcamp.socialmeli.model.Follow;
import com.javabootcamp.socialmeli.model.User;

public interface FollowRepository {
    void add(Follow follow);
    void delete(Integer followerId, Integer followedId);
    List<User> findFollowersById(Integer id);
    List<User> findFollowedsById(Integer id);
    Long countFollowersById(Integer id);
    Optional<Follow> findByFollowerIdAndFollowedId(Integer followerId, Integer followedId);
}
