package com.javabootcamp.socialmeli.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.javabootcamp.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private List<Post> postsList;

    public PostRepositoryImpl() {
        this.postsList = new ArrayList<>();
    }

    @Override
    public void add(Post post) {
        postsList.add(post);
    }

    @Override
    public List<Post> findByTwoWeeksAgo(List<Integer> sellersId) {
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        return postsList
                .stream()
                .filter(post -> (post.getDate().isAfter(twoWeeksAgo)
                        || post.getDate().isEqual(twoWeeksAgo))
                        && sellersId.contains(post.getUser().getId()))
                .toList();
    }

}
