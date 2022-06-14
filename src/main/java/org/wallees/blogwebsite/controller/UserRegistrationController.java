package org.wallees.blogwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.service.UserRegistrationService;
import org.wallees.blogwebsite.service.UserService;
import org.wallees.blogwebsite.web.UserRegistrationDto;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result) {

        UserRegistrationService userRegistrationService = new UserRegistrationService(userDto, userService, result);

        if (userRegistrationService.getResult().hasErrors()) {
            return "register";
        }

        userService.save(userDto);
        return "redirect:/register?success";
    }


}

