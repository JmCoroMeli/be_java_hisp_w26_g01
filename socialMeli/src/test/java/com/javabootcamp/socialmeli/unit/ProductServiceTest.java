package com.javabootcamp.socialmeli.unit;

import com.javabootcamp.socialmeli.service.PostService;
import com.javabootcamp.socialmeli.service.ProductServiceImpl;
import com.javabootcamp.socialmeli.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private PostService postService;

    @Mock
    private UserService userService;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void verifyDateOrderTypeExists(){



    }

}
