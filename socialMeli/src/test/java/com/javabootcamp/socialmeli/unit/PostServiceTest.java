package com.javabootcamp.socialmeli.unit;

import com.javabootcamp.socialmeli.repository.PostRepository;
import com.javabootcamp.socialmeli.service.PostService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    PostRepository postRepository;
    @InjectMocks
    PostService postService;

}
