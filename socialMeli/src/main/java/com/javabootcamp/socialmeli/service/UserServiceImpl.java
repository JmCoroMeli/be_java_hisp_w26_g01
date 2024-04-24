package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.FollowerDto;
import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    private final IFollowService followService;

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
    public ResponseDto addFollower(Integer followerdId, Integer followedId) {
        User follower = userRepository.findById(followerdId)
                .orElseThrow(() -> new EntityNotFoundException("Follower not found"));
        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new EntityNotFoundException("Followed not found"));
        followService.addFollow(follower, followed);
        return new ResponseDto("Follower added succesfully");
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
