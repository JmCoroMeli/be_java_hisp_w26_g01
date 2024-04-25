package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.FollowerDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.model.User;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface IFollowService {

    void addFollow(User follower, User followed);


    List<FollowerDto> searchFollowersByUser(int idUser);


    List<User> searchFollowedByUser(Integer idUser);

    List<User> searchFollowedByUserOrder(Integer idUser, OrderType order);

    ResponseDto deleteFollow(Integer followerId, Integer followedId);

    int countFollowers(User user);


    List<FollowerDto> searchFollowersByUserAndOrderDesc(Integer userId);


    List<FollowerDto> searchFollowersByUserAndOrderAsc(Integer userId);


}
