package org.wallees.blogwebsite.service;

import org.wallees.blogwebsite.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    List<Post> getLatestPosts(int limit);

    Post getPostById(Long id);

    void createPost(Post post);

    void deletePost(Post post);

    void editPost(Post post);
    
}
