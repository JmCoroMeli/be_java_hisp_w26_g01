package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.FollowersCountDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FollowServiceImpl implements IFollowService{
    private final FollowRepository followRepo;
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
    public int countFollowers(User user) {
        Integer userId = user.getId();
        return followRepo.countFollowersById(userId);
    }
}
