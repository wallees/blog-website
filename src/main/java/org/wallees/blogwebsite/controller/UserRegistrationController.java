package org.wallees.blogwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wallees.blogwebsite.validation.UserRegistrationValidation;
import org.wallees.blogwebsite.service.UserService;
import org.wallees.blogwebsite.web.UserRegistrationDto;

import javax.validation.Valid;

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

        UserRegistrationValidation userRegistrationValidation = new UserRegistrationValidation(userDto, userService, result);

        if (userRegistrationValidation.getResult().hasErrors()) {
            return "register";
        }

        userService.save(userDto);
        return "redirect:/register?success";
    }


}

