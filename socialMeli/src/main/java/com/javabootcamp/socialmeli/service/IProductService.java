package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.ProductDto;
import com.javabootcamp.socialmeli.model.Product;

public interface IProductService {
    Product addProduct(Product product);
    ProductDto productEntityToDto(Product product);
}
