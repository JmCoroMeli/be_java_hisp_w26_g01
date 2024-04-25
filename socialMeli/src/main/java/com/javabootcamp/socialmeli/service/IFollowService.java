package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.FollowerDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.model.User;

import java.util.List;

public interface IFollowService {

    void addFollow(User follower, User followed);


    List<FollowerDto> searchFollowersByUser(int idUser);


    List<User> searchFollowedByUser(Integer idUser);

    ResponseDto deleteFollow(Integer followerId, Integer followedId);

    Integer countFollowersById(Integer userId);


}
