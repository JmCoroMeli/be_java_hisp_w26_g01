package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostServiceImpl implements  IPostService{
    @Override
    public ResponseDto addPost(PostDto postDto) {
        return null;
    }

    @Override
    public List<PostDto> getLastestPosts() {
        return null;
    }
}
