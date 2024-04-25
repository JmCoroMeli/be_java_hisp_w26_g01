package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.ProductDto;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.model.Product;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    public ProductDto productEntityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        ObjectMapper mapper = new ObjectMapper();
        productDto= mapper.convertValue(product, ProductDto.class);
        return productDto;
    }

}
