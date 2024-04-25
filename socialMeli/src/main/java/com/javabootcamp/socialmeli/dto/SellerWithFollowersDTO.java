package com.javabootcamp.socialmeli.dto;

import lombok.Data;

import java.util.List;
@Data
public class SellerWithFollowersDTO {
    private int userId;
    private String userName;
    private List<FollowerDto> followers;
}
