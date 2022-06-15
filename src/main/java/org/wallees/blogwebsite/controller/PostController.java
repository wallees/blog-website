package org.wallees.blogwebsite.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.service.PostService;
import org.wallees.blogwebsite.service.UserService;
import org.wallees.blogwebsite.validation.PostValidation;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

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

    @GetMapping("/new")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "createpost";
    }

    @PostMapping
    public String createPost(@ModelAttribute("post") @Valid Post post, BindingResult result) {
        post.setDate(new Date());

        // TODO: Do this in a less terrible way.
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            var details = (UserDetails) principal;
            User user = userService.findByEmail(details.getUsername());
            if (user != null) {
                post.setUser(user);
            }
        }

        PostValidation createPostValidation = new PostValidation(post, result);
        if (createPostValidation.getResult().hasErrors()) {
            return "createpost";
        }
        postService.createPost(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/{id}")
    public String viewPost(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "post";
    }

    @GetMapping("/{id}/edit")
    public String editPostForm(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "editpost";
    }

    // HTML forms only support GET and POST; could submit PATCH via JS instead, but this will do for now
    @PostMapping("/{id}")
    public String editPost(@PathVariable(value = "id") Long id, @ModelAttribute("post") Post post, BindingResult result) {

        PostValidation editPostValidation = new PostValidation(post, result);
        if (editPostValidation.getResult().hasErrors()) {
            return "editpost";
        }
        postService.editPost(id, post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/{id}/delete")
    public String deletePostForm(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "deletepost";
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable(value = "id") Long id) {
        postService.deletePost(id);
    }

}
