package com.javabootcamp.socialmeli.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.javabootcamp.socialmeli.model.Follow;
import com.javabootcamp.socialmeli.model.Post;

public class PostRepositoryImpl implements PostRepository{

    private List<Post> posts ;

    public PostRepositoryImpl() {
        this.posts = new ArrayList<>();
    }

    @Override
    public void add(Post post) {

    }

    @Override
    public List<Post> findByTwoWeeksAgo() {
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        return posts.stream().filter(post -> post.getPublicationDate().isAfter(twoWeeksAgo)
                || post.getPublicationDate().isEqual(twoWeeksAgo)).toList();
    }

}
