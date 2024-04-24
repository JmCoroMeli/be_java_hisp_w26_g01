package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.FollowedSellersDto;
import com.javabootcamp.socialmeli.dto.SellerDto;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements IUserService{

    private final FollowServiceImpl followService;

    public UserServiceImpl(FollowServiceImpl followService) {
        this.followService = followService;
    }

    @Override
    public List<SellerDto> searchFollowersById(Integer userId) {
        return null;
    }

    @Override
    public List<FollowedSellersDto> searchFollowedById(Integer userId) {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = followService.searchFollowedByUser(userId);

        if (userList.isEmpty()) { //verifico si el usuario sigue a alguien
            throw new EntityNotFoundException("No se encontraron seguidores");
        }

        List<UserDto> userDtos = userList.stream()
                                .map(u -> mapper.convertValue(u, UserDto.class))
                                .collect(Collectors.toList());

        FollowedSellersDto followedSellersDto = new FollowedSellersDto(); //aca poner el id, name y la lista de dtos

        return followedSellersDto;
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
