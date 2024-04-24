package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.model.Post;
import com.javabootcamp.socialmeli.model.Product;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.PostRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {

    private static AtomicInteger CONTADOR = new AtomicInteger(1);

    private final PostRepository postRepository;
    private final IUserService userService;

    @Override
    public void addPost(PostDto postDto) {

        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.convertValue(postDto.getProduct(), Product.class);
        User user = userService.searchUserById(postDto.getIdUser());
        Post post = new Post(
                user,
                CONTADOR.getAndIncrement(),
                postDto.getDate(),
                product,
                postDto.getCategory(),
                postDto.getPrice(),
                false,
                0D);

        postRepository.add(post);
    }

    @Override
    public List<PostDto> getLastestPosts() {
        return null;
    }
}
