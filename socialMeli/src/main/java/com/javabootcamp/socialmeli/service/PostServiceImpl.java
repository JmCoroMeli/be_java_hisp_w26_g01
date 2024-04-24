package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.model.Post;
import com.javabootcamp.socialmeli.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements  IPostService{

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public ResponseDto addPost(PostDto postDto) {
        return null;
    }

    @Override
    public List<PostDto> findByTwoWeeksAgo() {
        List <Post> posts = postRepository.findByTwoWeeksAgo();
        List <PostDto> postDtos= new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        if(posts.isEmpty()){
            return postDtos;
        }else{
            posts.stream()
                    .map(v -> mapper.convertValue(v,PostDto.class))
                    .collect(Collectors.toList());
        }
        return postDtos;
    }

    public PostDto postToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setUserId(post.getUser().getId());
        postDto.

    }

}
