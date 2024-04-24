package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
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

    private IUserService userService;
    UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping
    @RequestMapping("/{userId}/followers/list")
    public ResponseEntity<SellerWithFollowersDTO> getFollowersOfSeller(@RequestParam int userId){

        SellerWithFollowersDTO response = userService.searchFollowersById(userId);

        return ResponseEntity.status(200).body(response);
    }


}
