package com.javabootcamp.socialmeli.utils;

import com.javabootcamp.socialmeli.model.Product;

import java.util.concurrent.atomic.AtomicInteger;

public class ProductBuilder {

    private static final AtomicInteger CONTADOR = new AtomicInteger(1);
    public static Product product(){
        return new Product(
                1,
                "Camisa negra",
                "Camisa",
                "Adidas",
                "Negra",
                "Muy comoda"
        );
    }
    
    public static void resetCounter(){
        CONTADOR.set(1);
    }
}
