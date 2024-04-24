package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.dto.SellerDto;

import java.util.List;

public interface IUserService {

    List<SellerDto> searchFollowersById(Integer userId);

    List<ClientDto> searchFollowerdById(Integer userId);

    Integer countFollowersById(Integer userId);

    void addFollower(Integer followerdId, Integer followedId);

    void deleteFollo(Integer followerId, Integer followedId);

    LastPostDto getPostFromLastTwoWeeks(Integer userId);

    public boolean existUser(Integer userId);
}
