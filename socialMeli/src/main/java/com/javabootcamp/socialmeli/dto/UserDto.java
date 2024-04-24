package com.javabootcamp.socialmeli.dto;

import com.javabootcamp.socialmeli.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String username;
    private UserType userType;
}
