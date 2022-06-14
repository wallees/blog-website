package org.wallees.blogwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wallees.blogwebsite.service.PostService;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("last3Posts", postService.getLatestPosts(3));
        model.addAttribute("last5Posts", postService.getLatestPosts(5));
        return "index";
    }

    @GetMapping("/createpost")
    public String createPost() {
        return "createpost";
    }

    @GetMapping("/editpost")
    public String editPost() {
        return "editpost";
    }

    @GetMapping("/deletepost")
    public String deletePost() {
        return "deletepost";
    }
    
}
