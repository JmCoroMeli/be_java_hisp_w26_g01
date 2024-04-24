package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.dto.ResponseDto;
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
    public ResponseEntity<ResponseDto> followUser(@PathVariable Integer userId, @PathVariable Integer userToFollow) {
        return ResponseEntity.ok(userService.addFollower(userId, userToFollow));
    }
}
