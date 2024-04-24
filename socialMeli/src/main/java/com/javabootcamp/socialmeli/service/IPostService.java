package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;

import java.util.List;

public interface IPostService {
    void addPost(PostDto postDto);

    List<PostDto> getLastestPosts();
}
