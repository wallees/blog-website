package org.wallees.blogwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public void deletePost(Long id) {
        this.postRepository.deleteById(id);
    }

    @Override
    public void deletePost(Post post) {
        deletePost(post.getId());
    }

    @Override
    public void editPost(Long id, Post editedPost) {
        Post originalPost = getPostById(id);
        originalPost.setTitle(editedPost.getTitle());
        originalPost.setBody(editedPost.getBody());
        this.postRepository.save(originalPost);
    }

    @Override
    public Page<Post> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.postRepository.findAll(pageable);
    }

}
