package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.dto.SellerDto;
import com.javabootcamp.socialmeli.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public void deleteFollo(Integer followerId, Integer followedId) {

    }

    @Override
    public boolean existUser(Integer userId) {
        return userRepository.findById(userId).isPresent();
    }

    @Override
    public LastPostDto getPostFromLastTwoWeeks(Integer userId) {
        //valivamos que el usuario existe
         if(!existUser(userId)) {
             //lanzar excepción
         }



    }
}
