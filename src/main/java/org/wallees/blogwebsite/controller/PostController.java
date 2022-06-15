package org.wallees.blogwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.service.PostService;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public String viewPosts(@RequestParam(value = "page", defaultValue = "1") int pageNo, Model model) {
        int pageSize = 10;
        Page<Post> page = postService.findPaginated(pageNo, pageSize);
        List<Post> postList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("postList", postList);
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
