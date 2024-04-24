package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ClientDto;
import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.dto.SellerDto;

import java.util.List;
import java.util.Optional;

import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    private final IPostService postService;

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

        postService.findByTwoWeeksAgo()





    }
}
