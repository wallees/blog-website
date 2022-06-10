package org.wallees.blogwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/viewposts")
    public String viewPosts(){
        return "viewposts";
    }
    @GetMapping("/createpost")
    public String createPost(){
        return "createpost";
    }
    @GetMapping("/editpost")
    public String editPost(){
        return "editpost";
    }
    @GetMapping("/deletepost")
    public String deletePost(){
        return "deletepost";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/users")
    public String users(){
        return "users";
    }
}
