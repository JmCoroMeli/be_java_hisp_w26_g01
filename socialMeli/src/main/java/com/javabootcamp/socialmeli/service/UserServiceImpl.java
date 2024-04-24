package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.FollowerDto;
import com.javabootcamp.socialmeli.dto.SellerDto;
import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements IUserService{

    private IFollowService followService;
    private UserRepository userRepository;
    UserServiceImpl(IFollowService followService, UserRepository userRepository){
        this.followService = followService;
        this.userRepository = userRepository;
    }

    @Override
    public SellerWithFollowersDTO searchFollowersById(Integer userId) {
        Optional<User> user = userRepository.findById(userId);

        if(!user.isPresent()) throw new EntityNotFoundException("No existe un usuario con id: + " + userId);

        SellerWithFollowersDTO sellerWithFollowersDTO = new SellerWithFollowersDTO();


        List<FollowerDto> followersDto  = followService.searchFollowersByUser(userId);

        sellerWithFollowersDTO.setUserId(user.get().getId());
        sellerWithFollowersDTO.setUserName(user.get().getUsername());
        sellerWithFollowersDTO.setFollowers(followersDto);

        return sellerWithFollowersDTO;
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
}
