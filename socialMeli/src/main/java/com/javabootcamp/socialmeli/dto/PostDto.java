package com.javabootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("post_id")
    private LocalDate publicationDate;
    private ProductDto product;
    private Integer category;
    private Double price;
}
