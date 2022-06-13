package org.wallees.blogwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    //Sets quantity of posts to be shown on home page
    int numOfPosts = 5;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    //Need to add Pagination functionality first
    @Override
    public List<Post> getLatest() {
        return null;
    }

    @Override
    public Post getPostById(Long id) {
        Optional<Post> optional = postRepository.findById(id);
        Post post = null;
        if (optional.isPresent()) {
            post = optional.get();
        } else {
            throw new RuntimeException("Post not found.");
        } return post;
    }

    @Override
    public void createPost(Post post) {
        this.postRepository.save(post);
    }

    @Override
    public void deletePost(Post post) {
        this.postRepository.deleteById(post.getId());
    }

    @Override
    public void editPost(Post post) {
        this.postRepository.save(post);
    }

}
