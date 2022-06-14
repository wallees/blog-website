package org.wallees.blogwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String viewUsers(@RequestParam(value = "page", defaultValue = "1") int pageNo, Model model) {
        int pageSize = 10;
        Page<User> page = userService.findPaginated(pageNo, pageSize);
        List<User> userList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/{id}")
    public String viewUser(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

}
