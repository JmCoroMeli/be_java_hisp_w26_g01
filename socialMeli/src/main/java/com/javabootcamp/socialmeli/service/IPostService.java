package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;

import java.util.List;

public interface IPostService {
    List<PostDto> findByTwoWeeksAgo(List<Integer> sellersId);
    void addPost(PostDto postDto);
}
