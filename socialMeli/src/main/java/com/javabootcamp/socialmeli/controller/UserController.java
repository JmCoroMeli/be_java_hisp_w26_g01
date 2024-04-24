package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{userId}/followed/list")
    public ResponseEntity<?> getFollowedByUserId(@PathVariable Integer userId) {
        return new ResponseEntity<>(userService.searchFollowedById(userId), HttpStatus.OK);
    }
}
