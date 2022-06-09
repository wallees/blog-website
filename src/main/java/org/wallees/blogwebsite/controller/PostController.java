package org.wallees.blogwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    //Temporary mapping for home page (until homeController is created)
    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Post> allPosts = postService.getAllPosts();
        List<Post> last3Posts = allPosts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("last3Posts", last3Posts);
        return "index";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("post") Post post){
        postService.createPost(post);
        return "redirect:/";
    }


}
