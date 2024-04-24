package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.SellerDto;
import com.javabootcamp.socialmeli.dto.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> getAllUsers();

    List<SellerDto> searchFollowersById(Integer userId);

    List<ClientDto> searchFollowerdById(Integer userId);

    Integer countFollowersById(Integer userId);

    void addFollower(Integer followerdId, Integer followedId);

    ResponseDto deleteFollow(Integer followerId, Integer followedId);
}
