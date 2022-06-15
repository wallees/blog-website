package org.wallees.blogwebsite.service;

import org.springframework.data.domain.Page;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.model.User;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    List<Post> getLatestPosts(int limit);

    Post getPostById(Long id);

    void createPost(Post post);

    void deletePost(Post post);

    void editPost(Post post);

    Page<Post> findPaginated(int pageNo, int pageSize);
    
}
