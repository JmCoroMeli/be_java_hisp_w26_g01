package com.javabootcamp.socialmeli.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.request.PostDto;
import com.javabootcamp.socialmeli.dto.request.ProductDto;
import com.javabootcamp.socialmeli.model.Post;
import com.javabootcamp.socialmeli.model.Product;

public class DtoMapper {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private DtoMapper(){}

    public static ProductDto productEntityToDto(Product product) {
        return MAPPER.convertValue(product, ProductDto.class);
    }

    public static PostDto postToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setDate(post.getDate());
        postDto.setIdUser(post.getUser().getId());
        postDto.setProduct(productEntityToDto(post.getProduct()));
        postDto.setCategory(post.getCategory());
        postDto.setPrice(post.getPrice());
        return postDto;
    }
}
