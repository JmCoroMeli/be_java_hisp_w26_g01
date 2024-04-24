package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.FollowerDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.exception.ResourceAlreadyExistsException;
import com.javabootcamp.socialmeli.model.Follow;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.FollowRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements IFollowService{
    private final FollowRepository followRepository;

    @Override
    public void addFollow(User follower, User followed) {
        followRepository.findByFollowerIdAndFollowedId(follower.getId(),followed.getId())
                .ifPresent((v) -> {throw new ResourceAlreadyExistsException("Follow already exists");});
        followRepository.add(new Follow(follower, followed, LocalDate.now()));
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
