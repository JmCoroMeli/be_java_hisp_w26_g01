package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.*;
import com.javabootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserService {

    FollowedSellersDto searchFollowedById(Integer userId);
    List<UserDto> getAllUsers();
    SellerWithFollowersDTO searchFollowersById(Integer userId);
    Integer countFollowersById(Integer userId);

    ResponseDto addFollower(Integer followerdId, Integer followedId);

    ResponseDto deleteFollower(Integer followerId, Integer followedId);
    List<Integer> getListSellerId(Integer userId);
    User searchUserById(Integer id);
}
