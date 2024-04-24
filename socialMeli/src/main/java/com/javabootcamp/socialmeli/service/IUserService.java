package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.SellerDto;
import com.javabootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserService {

    List<SellerDto> searchFollowersById(Integer userId);

    List<ClientDto> searchFollowerdById(Integer userId);

    Integer countFollowersById(Integer userId);

    ResponseDto addFollower(Integer followerdId, Integer followedId);

    void deleteFollo(Integer followerId, Integer followedId);

    User searchUserById(Integer id);
}
