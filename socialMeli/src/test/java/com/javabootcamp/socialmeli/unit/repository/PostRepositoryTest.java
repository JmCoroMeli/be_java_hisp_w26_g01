package com.javabootcamp.socialmeli.unit.repository;


import com.javabootcamp.socialmeli.model.Post;
import com.javabootcamp.socialmeli.repository.PostRepository;
import com.javabootcamp.socialmeli.repository.PostRepositoryImpl;
import com.javabootcamp.socialmeli.utils.PostBuilder;
import com.javabootcamp.socialmeli.utils.ProductBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PostRepositoryTest {

    private static PostRepository postRepository;
    @BeforeEach
    void init(){
        postRepository = new PostRepositoryImpl();
        postRepository.add(PostBuilder.post(LocalDate.of(2024,5,3),2));
        postRepository.add(PostBuilder.post(LocalDate.of(2024,5,1),1));
        postRepository.add(PostBuilder.post(LocalDate.of(2024,5,5),3));
        ProductBuilder.resetCounter();
    }

    //T-0006
    @Test
    void orderPostDateAsc(){
        List<Post> listOfPostExpected = List.of(
                PostBuilder.post(LocalDate.of(2024,5,1),1),
                PostBuilder.post(LocalDate.of(2024,5,3),2),
                PostBuilder.post(LocalDate.of(2024,5,5),3)
        );

        List<Post> listOfPostResult = postRepository.findByTwoWeeksAgoOrderAsc(List.of(2));
        Assertions.assertIterableEquals(listOfPostExpected,listOfPostResult);
    }

    //T-0008
    @Test
    public void findByTwoWeeksAgoTest() {
        //Agrego un post adicional con mas de dos semanas.
        postRepository.add(PostBuilder.post(LocalDate.of(2024,3,5),4));

        int countExpected = 3;

        List<Post> listOfPostExpected = List.of(
                PostBuilder.post(LocalDate.of(2024,5,3),2),
                PostBuilder.post(LocalDate.of(2024,5,1),1),
                PostBuilder.post(LocalDate.of(2024,5,5),3)
        );

        List<Post> resultPosts = postRepository.findByTwoWeeksAgo(List.of(2));

        Assertions.assertEquals(countExpected, resultPosts.size());

        Assertions.assertIterableEquals(listOfPostExpected,resultPosts);

        Assertions.assertTrue(resultPosts.stream().allMatch(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2))
                || post.getDate().isEqual(LocalDate.now().minusWeeks(2))));
    }


}