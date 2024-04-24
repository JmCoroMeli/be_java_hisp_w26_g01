package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.repository.UserRepository;
import com.javabootcamp.socialmeli.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    @PostMapping(path = "{userId}/follow/{userToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Integer userId, @PathVariable Integer userToFollow) {
        userService.addFollower(userId, userToFollow);
        return ResponseEntity.ok().build();
    }
}
