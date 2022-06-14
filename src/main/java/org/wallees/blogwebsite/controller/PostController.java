package org.wallees.blogwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public String viewPosts() {
        return "posts";
    }

    @GetMapping("/{id}")
    public String viewPost(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "post";
    }

    @PostMapping
    public String createPost(@ModelAttribute("post") Post post) {
        postService.createPost(post);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String editPost(@ModelAttribute("post") Post post) {
        postService.editPost(post);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@ModelAttribute("post") Post post) {
        postService.deletePost(post);
        return "redirect:/";
    }
}
