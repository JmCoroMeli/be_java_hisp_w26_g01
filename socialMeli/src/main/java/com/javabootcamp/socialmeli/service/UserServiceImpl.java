package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.javabootcamp.socialmeli.dto.FollowedSellersDto;
import com.javabootcamp.socialmeli.dto.SellerDto;
import com.javabootcamp.socialmeli.dto.UserDto;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.dto.PostDto;

import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.dto.FollowerDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.SellerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.repository.UserRepository;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    private final IPostService postService;

    private final IFollowService followService;

    @Override
    public List<UserDto> getAllUsers() {
        ObjectMapper mapper = new ObjectMapper();
        return userRepository.getAllUsers().stream().map(u -> mapper.convertValue(u,UserDto.class)).collect(Collectors.toList());

    }



    @Override
    public SellerWithFollowersDTO searchFollowersById(Integer userId) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()) throw new EntityNotFoundException("No existe un usuario con id: + " + userId);

        SellerWithFollowersDTO sellerWithFollowersDTO = new SellerWithFollowersDTO();

        List<FollowerDto> followersDto  = followService.searchFollowersByUser(userId);

        sellerWithFollowersDTO.setUserId(user.get().getId());
        sellerWithFollowersDTO.setUserName(user.get().getUsername());
        sellerWithFollowersDTO.setFollowers(followersDto);

        return sellerWithFollowersDTO;
    }

    @Override
    public FollowedSellersDto searchFollowedById(Integer userId) {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = followService.searchFollowedByUser(userId);
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
    public ResponseDto addFollower(Integer followerdId, Integer followedId) {
        User follower = userRepository.findById(followerdId)
                .orElseThrow(() -> new EntityNotFoundException("Follower not found"));
        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new EntityNotFoundException("Followed not found"));
        followService.addFollow(follower, followed);
        return new ResponseDto("Follower added succesfully");
    }

    @Override
    public ResponseDto deleteFollower(Integer followerId, Integer followedId) {
        return followService.deleteFollow(followerId,followedId);
    }

    @Override
    public User searchUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new EntityNotFoundException("No existe el usuario");
        }
        return user.get();
    }

    @Override
    public LastPostDto getPostFromLastTwoWeeks(Integer userId) {
        User user = searchUserById(userId);
        List<Integer> sellerList=new ArrayList<>();
        List<PostDto> postsDto= postService.findByTwoWeeksAgo( sellerList);
        if(postsDto.isEmpty()){
            throw new EntityNotFoundException("No existen posteos de los vendedores seguidos.");
        }
        return new LastPostDto(user.getId(),postsDto);
    }
}
