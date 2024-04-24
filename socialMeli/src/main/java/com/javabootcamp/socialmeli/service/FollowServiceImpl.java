package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.FollowedSellersDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FollowServiceImpl implements IFollowService{

    private final FollowRepository followRepository;

    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public ResponseDto addFollow(User follower, User followed) {
        return null;
    }

    @Override
    public List<FollowedSellersDto> searchFollowersByUser(User user) {

        return null;
    }

    @Override
    public List<User> searchFollowedByUser(User user) {
        return followRepository.findFollowedsById(user.getId());
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
