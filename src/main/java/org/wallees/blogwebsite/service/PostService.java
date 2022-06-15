package org.wallees.blogwebsite.service;

import org.springframework.data.domain.Page;
import org.wallees.blogwebsite.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    List<Post> getLatestPosts(int limit);

    Post getPostById(Long id);

    void createPost(Post post);

    void deletePost(Long id);

    void deletePost(Post post);

    void editPost(Long id, Post editedPost);

    Page<Post> findPaginated(int pageNo, int pageSize);

}
