package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.service.IUserService;
import com.javabootcamp.socialmeli.service.UserServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        return new ResponseEntity<>(userService.deleteFollow(userId,userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{userId}/followers/list")
    public ResponseEntity<SellerWithFollowersDTO> getFollowersOfSeller(@RequestParam int userId){

        SellerWithFollowersDTO response = userService.searchFollowersById(userId);

        return ResponseEntity.status(200).body(response);
    }

    @PostMapping(path = "{userId}/follow/{userToFollow}")
    public ResponseEntity<ResponseDto> followUser(@PathVariable Integer userId, @PathVariable Integer userToFollow) {
        return ResponseEntity.ok(userService.addFollower(userId, userToFollow));
    }
}
