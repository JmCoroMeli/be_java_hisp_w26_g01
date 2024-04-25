package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.service.IPostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;
    private final IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<Void> postPost(@RequestBody PostDto post){
        postService.addPost(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<LastPostDto> getPostFromLastTwoWeeks(@RequestParam("userId") int userId){
        return ResponseEntity.ok(productService.getPostFromLastTwoWeeks(userId));
    }

}
