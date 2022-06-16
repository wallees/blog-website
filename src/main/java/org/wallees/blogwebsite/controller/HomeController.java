package org.wallees.blogwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wallees.blogwebsite.service.PostService;
import org.wallees.blogwebsite.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("last3Posts", postService.getLatestPosts(3));
        model.addAttribute("last5Posts", postService.getLatestPosts(5));
        model.addAttribute("currentUser", userService.getCurrentUser());
        return "index";
    }
    
}
