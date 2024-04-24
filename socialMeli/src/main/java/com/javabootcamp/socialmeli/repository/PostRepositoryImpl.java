package com.javabootcamp.socialmeli.repository;

import java.util.List;

import com.javabootcamp.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostRepository{

    @Override
    public void add(Post post) {

    }

    @Override
    public List<Post> findByTwoWeeksAgo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTwoWeeksAgo'");
    }

}
