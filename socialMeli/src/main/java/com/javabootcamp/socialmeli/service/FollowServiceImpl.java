package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.model.User;

import java.util.List;

public class FollowServiceImpl implements IFollowService{
    @Override
    public ResponseDto addFollow(User follower, User followed) {
        return null;
    }

    @Override
    public List<UserDto> searchFollowersByUser(User user) {
        return null;
    }

    @Override
    public List<UserDto> searchFollowedByUser(User user) {
        return null;
    }

    @Override
    public ResponseDto deleteFollow(Integer followerId, Integer followedId) {
        return null;
    }

    @Override
    public Integer countFollowersById(Integer userId) {
        return null;
    }
}
