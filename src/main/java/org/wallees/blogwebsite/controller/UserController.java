package org.wallees.blogwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model){
        int pageSize = 10;
        Page<User> page = userService.findPaginated(pageNo, pageSize);
        List<User> userList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/users")
    public String viewUsers(Model model) {
        return findPaginated(1, model);
    }

}
