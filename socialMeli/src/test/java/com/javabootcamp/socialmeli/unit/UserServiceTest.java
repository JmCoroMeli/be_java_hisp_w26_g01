package com.javabootcamp.socialmeli.unit;

import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.exception.IllegalActionException;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.UserRepository;
import com.javabootcamp.socialmeli.service.FollowService;
import com.javabootcamp.socialmeli.service.UserServiceImpl;
import com.javabootcamp.socialmeli.utils.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    FollowService followService;

    @InjectMocks
    UserServiceImpl userService;
    private static User CLIENT;
    private static User SELLER;
    @BeforeAll
    static void init(){
        CLIENT = UserBuilder.userClient(1);
        SELLER = UserBuilder.userSeller(2);
    }

    //T-0001 -> Se cumple
    @Test
    void whenTryFollowUserAndUserExists(){
        Integer followerId = CLIENT.getId();
        Integer followedId = SELLER.getId();

        Mockito.when(userRepository.findById(followerId))
                    .thenReturn(Optional.of(CLIENT));

        Mockito.when(userRepository.findById(followedId))
                        .thenReturn(Optional.of(SELLER));

        userService.addFollower(followerId,followedId);

        Mockito.verify(userRepository).findById(followerId);
        Mockito.verify(followService).addFollow(CLIENT,SELLER);
    }

    //T-0001 -> No se cumple
    @Test
    void whenTryFollowUserAndUserDoesNotExist() {
        Integer followerId = 1;
        Integer followedId = 2;

        Mockito.when(userRepository.findById(1))
                .thenReturn(Optional.of(CLIENT));
        Mockito.when(userRepository.findById(2))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> userService.addFollower(followerId,followedId));
    }


    // T-0002 Verificar que el usuario a dejar de seguir exista. (US-0007)
    @Test
    public void whenTryUnfollowUserAndUserExist(){
        int idFollower = 1;
        int idFollowed = 2;

        ResponseDto expectedResponse = new ResponseDto("User: " + idFollower +
                                        " successfully stopped following: " + idFollowed);

        Mockito.when(userRepository.findById(idFollowed)).thenReturn(Optional.of(UserBuilder.userSeller(idFollowed)));

        Mockito.when(followService.deleteFollow(idFollower, idFollowed))
                                        .thenReturn(expectedResponse);

        ResponseDto response = userService.deleteFollower(idFollower, idFollowed);


        Assertions.assertEquals(response.getMessage(), expectedResponse.getMessage());

    }

    @Test
    public void whenTryUnfollowUserAndUserDoesNotExist(){
        int idFollowed = 1;
        int idFollower = 2;

        Mockito.when(userRepository.findById(idFollowed))
                .thenThrow(new EntityNotFoundException("User does not exist."));

        Assertions.assertThrows(EntityNotFoundException.class, ()-> userService.deleteFollower(idFollower, idFollowed));

    }

    //T-0003 Followers -> Se cumple
    @Test
    void whenTrySearchFollowersOrderByNameAsc(){
        Mockito.when(userRepository.findById(SELLER.getId())).thenReturn(Optional.of(SELLER));
        userService.searchFollowersById(SELLER.getId(), OrderType.name_asc);
        Mockito.verify(followService).searchFollowersByUserAndOrderAsc(SELLER.getId());
    }

    //T-0003 Followers -> No se cumple
    @Test
    void whenTrySearchFollowersWithInvalidOrderThenReturnException(){
        Assertions.assertThrows(IllegalActionException.class, () -> userService.searchFollowersById(SELLER.getId(),OrderType.date_asc));
    }


    //T-0003 Followed -> Se cumple
    @Test
    void whenTrySearchFollowedsOrderByNameAsc(){
        Mockito.when(userRepository.findById(CLIENT.getId())).thenReturn(Optional.of(CLIENT));
        userService.searchFollowedById(CLIENT.getId(), OrderType.name_asc);
        Mockito.verify(followService).searchFollowedByUserOrder(CLIENT.getId(), OrderType.name_asc );
    }

    //T-0003 Followed -> No se cumple
    @Test
    void whenTrySearchFollowedsWithInvalidOrderThenReturnException(){
        Assertions.assertThrows(IllegalActionException.class, () -> userService.searchFollowedById(CLIENT.getId(),OrderType.date_asc));
    }

}