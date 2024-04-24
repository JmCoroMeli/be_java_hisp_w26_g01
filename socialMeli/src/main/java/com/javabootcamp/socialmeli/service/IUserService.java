package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.FollowedSellersDto;
import com.javabootcamp.socialmeli.dto.SellerDto;

import java.util.List;

public interface IUserService {

    List<SellerDto> searchFollowersById(Integer userId);

    List<FollowedSellersDto> searchFollowedById(Integer userId);

    Integer countFollowersById(Integer userId);

    void addFollower(Integer followerdId, Integer followedId);

    void deleteFollo(Integer followerId, Integer followedId);
}
