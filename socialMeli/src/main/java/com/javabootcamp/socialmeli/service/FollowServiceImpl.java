package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.FollowerDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.FollowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FollowServiceImpl implements IFollowService{

    private FollowRepository followRepository;
    public FollowServiceImpl(FollowRepository followRepository){
     this.followRepository = followRepository;
    }

    @Override
    public ResponseDto addFollow(User follower, User followed) {
        return null;
    }

    @Override
    public List<FollowerDto> searchFollowersByUser(int idUser) {

        List<User> listFollowers = followRepository.findFollowersById(idUser);



        return listFollowers.stream().map(follower ->{

                    FollowerDto followerDto = new FollowerDto();
                    followerDto.setUserId(follower.getId());
                    followerDto.setUserName(follower.getUsername());
                    return followerDto;})
                .toList();

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
