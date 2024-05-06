package com.javabootcamp.socialmeli.utils;

import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.enums.UserType;
import com.javabootcamp.socialmeli.model.User;

import java.util.List;

public class UserBuilder {
    public static List<User> clientList() {
        return List.of(
                userClient(1, "Franco"),
                userClient(2, "Juan"),
                userClient(3, "Rodrigo"),
                userClient(4, "Ignacio")
        );
    }
    public static List<UserDto> clientListNameDesc() {
        return List.of(
                new UserDto(1, "Franco"),
                new UserDto(4, "Ignacio"),
                new UserDto(2, "Juan"),
                new UserDto(3, "Rodrigo")
                );
    }

    public static User userClient(Integer id, String name){
        return user(id, name, UserType.CLIENT);
    }

    public static User userClient(Integer id){
        return user(id, UserType.CLIENT.name(), UserType.CLIENT);
    }

    public static User userSeller(Integer id){
        return user(id,UserType.SELLER.name(), UserType.SELLER);
    }

    private static User user(Integer id, String username, UserType userType){
        return new User(id,username,userType);
    }
}
