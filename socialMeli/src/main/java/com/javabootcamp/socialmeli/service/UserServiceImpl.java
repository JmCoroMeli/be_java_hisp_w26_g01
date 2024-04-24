package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.SellerDto;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.repository.UserRepository;
import com.javabootcamp.socialmeli.repository.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements IUserService{
    IFollowService followService;
    UserRepository userRepository;

    public UserServiceImpl(FollowServiceImpl followService, UserRepositoryImpl userRepository) {
        this.followService = followService;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        ObjectMapper mapper = new ObjectMapper();
        return userRepository.getAllUsers().stream().map(u -> mapper.convertValue(u,UserDto.class)).collect(Collectors.toList());

    }

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
    public ResponseDto deleteFollow(Integer followerId, Integer followedId) {
        return followService.deleteFollow(followerId,followedId);
    }
}
