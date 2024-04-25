package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.model.Product;

public interface IProductService {
    Product addProduct(Product product);
    LastPostDto getPostFromLastTwoWeeks(Integer userId);
}
