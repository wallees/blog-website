package org.wallees.blogwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.repository.PostRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    @Override
    public List<Post> getLatestPosts(int limit) {
        List<Post> allPosts = getAllPosts();
        allPosts.sort(
                (a, b) -> -a.getDate().compareTo(b.getDate()));

        return allPosts.stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public Post getPostById(Long id) {
        Optional<Post> optional = postRepository.findById(id);
        Post post;
        if (optional.isPresent()) {
            post = optional.get();
        } else {
            throw new RuntimeException("Post not found.");
        }
        return post;
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
