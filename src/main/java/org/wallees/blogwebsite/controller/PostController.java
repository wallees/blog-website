package org.wallees.blogwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.service.PostService;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("post") Post post) {
        postService.createPost(post);
        return "redirect:/";
    }

}
