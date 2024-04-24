package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.ProductDto;
import com.javabootcamp.socialmeli.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{
    @Override
    public Product addProduct(Product product) {
        return null;
    }

    public ProductDto productEntityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        ObjectMapper mapper = new ObjectMapper();
        productDto= mapper.convertValue(product, ProductDto.class);
        return productDto;
    }

}
