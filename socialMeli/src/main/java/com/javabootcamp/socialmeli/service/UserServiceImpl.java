package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.SellerDto;
import com.javabootcamp.socialmeli.enums.UserType;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.exception.IllegalActionException;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{
    private final UserRepository userRepository;
    private final IFollowService followService;
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
    public ResponseDto addFollower(Integer followerdId, Integer followedId) {
        User follower = userRepository.findById(followerdId)
                .orElseThrow(() -> new EntityNotFoundException("Follower not found"));
        if (follower.getUserType() == UserType.SELLER) {
            throw new IllegalActionException("Seller cannot follow");
        }
        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new EntityNotFoundException("Followed not found"));
        if (followed.getUserType() == UserType.CLIENT) {
            throw new IllegalActionException("Cannot follow a client");
        }
        followService.addFollow(follower, followed);
        return new ResponseDto("Follower added succesfully");
    }

    @Override
    public void deleteFollo(Integer followerId, Integer followedId) {

    }
}
