package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;

import java.util.List;

public interface IPostService {
    ResponseDto addPost(PostDto postDto);
    List<PostDto> findByTwoWeeksAgo();
}
