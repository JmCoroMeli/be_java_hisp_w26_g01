package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.SellerDto;
import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;

import java.util.List;

public interface IUserService {

    SellerWithFollowersDTO searchFollowersById(Integer userId);

    List<ClientDto> searchFollowerdById(Integer userId);

    Integer countFollowersById(Integer userId);

    void addFollower(Integer followerdId, Integer followedId);

    void deleteFollo(Integer followerId, Integer followedId);
}
