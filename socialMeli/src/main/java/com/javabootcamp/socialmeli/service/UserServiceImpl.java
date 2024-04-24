package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.FollowedSellersDto;
import com.javabootcamp.socialmeli.dto.SellerDto;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final FollowServiceImpl followService;
    private final UserRepository userRepository;



    @Override
    public List<SellerDto> searchFollowersById(Integer userId) {
        return null;
    }

    @Override
    public FollowedSellersDto searchFollowedById(Integer userId) {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = followService.searchFollowedByUser(searchUserById(userId));

        if (userList.isEmpty()) { //verifico si el usuario sigue a alguien
            throw new EntityNotFoundException("No se encontraron seguidores");
        }

        List<UserDto> userDtos = userList.stream()
                                .map(u -> mapper.convertValue(u, UserDto.class))
                                .collect(Collectors.toList());

        FollowedSellersDto followedSellersDto = new FollowedSellersDto(userId,
                                                                        searchUserById(userId).getUsername(),
                                                                        userDtos);
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

    @Override
    public User searchUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new EntityNotFoundException("No existe el usuario");
        }
        return user.get();
    }
}
