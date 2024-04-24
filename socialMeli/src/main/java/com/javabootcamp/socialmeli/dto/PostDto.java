package com.javabootcamp.socialmeli.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    @JsonProperty("user_id")
    private Integer id;
    private LocalDate date;
    private ProductDto product;
    private Integer category;
    private Double price;
}
