package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.SellerDto;

import java.util.List;

public class UserServiceImpl implements IUserService{
    @Override
    public List<SellerDto> searchFollowersById(Integer userId) {
        return null;
    }

    @Override
    public List<ClientDto> searchFollowerdById(Integer userId) {
        return null;
    }

    @Override
    public Integer countFollowersById(Integer userId) {
        return null;
    }

    @Override
    public void addFollower(Integer followerdId, Integer followedId) {

    }

    @Override
    public void deleteFollo(Integer followerId, Integer followedId) {

    }
}
