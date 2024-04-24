package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.service.IUserService;
import com.javabootcamp.socialmeli.repository.UserRepository;
import com.javabootcamp.socialmeli.service.IUserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

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
