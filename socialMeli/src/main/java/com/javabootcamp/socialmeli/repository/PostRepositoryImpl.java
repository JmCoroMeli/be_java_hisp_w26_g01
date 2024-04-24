package com.javabootcamp.socialmeli.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javabootcamp.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostRepository{

    private List<Post> postsList;

    public PostRepositoryImpl(){
        this.postsList = new ArrayList<>();
    }

    @Override
    public void add(Post post) {
        postsList.add(post);
    }

    @Override
    public List<Post> findByTwoWeeksAgo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTwoWeeksAgo'");
    }

}
