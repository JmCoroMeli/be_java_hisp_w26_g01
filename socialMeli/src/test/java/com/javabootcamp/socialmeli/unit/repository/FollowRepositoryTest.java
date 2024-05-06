package com.javabootcamp.socialmeli.unit.repository;

import com.javabootcamp.socialmeli.model.Follow;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.FollowRepository;
import com.javabootcamp.socialmeli.repository.FollowRepositoryImpl;
import com.javabootcamp.socialmeli.utils.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class FollowRepositoryTest {
    FollowRepository followRepository;
    @BeforeEach
    void setUp() {
        User seller = UserBuilder.userSeller(1, "Marcos");
        User client = UserBuilder.userClient(2,"Franco");
        followRepository = new FollowRepositoryImpl();
        // creating follows with repeated seller
        followRepository.add(new Follow(
                client,
                seller,
                LocalDate.now()
        ));
        followRepository.add(new Follow(
                UserBuilder.userClient(3,"Rodrigo"),
                seller,
                LocalDate.now()
        ));
        followRepository.add(new Follow(
                UserBuilder.userClient(4,"Ignacio"),
                seller,
                LocalDate.now()
        ));
        // Creating follows with repeated client
        followRepository.add(new Follow(
                client,
                UserBuilder.userSeller(5, "Eliana"),
                LocalDate.now()
        ));
        followRepository.add(new Follow(
                client,
                UserBuilder.userSeller(6, "Juan"),
                LocalDate.now()
        ));
    }

    //T-0004 -> Followers asc
    @Test
    void getFollowersByIdOrdersAscCorrectly() {
        List<User> expected = List.of(
                UserBuilder.userClient(2,"Franco"),
                UserBuilder.userClient(4, "Ignacio"),
                UserBuilder.userClient(3, "Rodrigo")
        );

        List<User> actual = followRepository.searchFollowersByUserAndOrderAsc(1);

        Assertions.assertIterableEquals(expected,actual);
    }
    //T-0004 -> Followers desc
    @Test
    void getFollowersByIdOrdersDescCorrectly() {
        List<User> expected = List.of(
                UserBuilder.userClient(3, "Rodrigo"),
                UserBuilder.userClient(4, "Ignacio"),
                UserBuilder.userClient(2,"Franco")
                );

        List<User> actual = followRepository.searchFollowersByUserAndOrderDesc(1);

        Assertions.assertIterableEquals(expected,actual);
    }
    //T-0004 -> Followed asc
    @Test
    void getFollowedByIdOrdersAscCorrectly() {
        List<User> expected = List.of(
                UserBuilder.userSeller(5, "Eliana"),
                UserBuilder.userSeller(6, "Juan"),
                UserBuilder.userSeller(1,"Marcos")
                );

        List<User> actual = followRepository.findFollowedsByIdAsc(2);

        Assertions.assertIterableEquals(expected,actual);
    }
    //T-0004 -> Followed desc
    @Test
    void getFollowedByIdOrdersDescCorrectly() {
        List<User> expected = List.of(
                UserBuilder.userSeller(1,"Marcos"),
                UserBuilder.userSeller(6, "Juan"),
                UserBuilder.userSeller(5, "Eliana")
                );

        List<User> actual = followRepository.findFollowedsByIdDesc(2);

        Assertions.assertIterableEquals(expected,actual);
    }


    //T-0007
    @Test
    public void testCountFollowersById() {
        int expected = 3;
        int result = followRepository.countFollowersById(1);
        Assertions.assertEquals(expected, result);

    }
}
