package org.wallees.blogwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
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
    @GetMapping("/users")
    public String users(){
        return "users";
    }
}
