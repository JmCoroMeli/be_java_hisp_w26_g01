package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.model.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{

    private final IPostService postService;
    private final IUserService userService;

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public LastPostDto getPostFromLastTwoWeeks(Integer userId) {
        //busco la lista de id de los vendedores seguidos
        List<Integer> sellerList=userService.getListSellerId(userId);
        //busco los posteos de las últimas dos semanas
        List<PostDto> postsDto= postService.findByTwoWeeksAgo( sellerList);
        if(postsDto.isEmpty()){
            throw new EntityNotFoundException("No existen posteos de los vendedores seguidos.");
        }
        return new LastPostDto(userId,postsDto);
    }

}
