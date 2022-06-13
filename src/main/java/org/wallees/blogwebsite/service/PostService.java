package org.wallees.blogwebsite.service;

import org.wallees.blogwebsite.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();
    Post getPostById(Long id);
    void createPost(Post post);
}
