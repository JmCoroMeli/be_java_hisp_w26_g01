package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.FollowRepository;
import com.javabootcamp.socialmeli.repository.FollowRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class FollowServiceImpl implements IFollowService{
    private FollowRepository followRepository;
    public FollowServiceImpl(FollowRepositoryImpl followRepository) {
        this.followRepository = followRepository;
    }

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
        ResponseDto response = new ResponseDto();
        try{
            followRepository.delete(followerId,followedId);
            response.setMessage("El usuario: " + followerId + " dejó de seguir a: " + followedId + " con exito.");
        }catch (Exception e){
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public Integer countFollowersById(Integer userId) {
        return null;
    }
}
