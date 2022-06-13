package org.wallees.blogwebsite.service;

import org.springframework.validation.BindingResult;
import org.wallees.blogwebsite.web.UserRegistrationDto;

public class UserRegistrationService {

    UserRegistrationDto userDto;
    UserService userService;
    BindingResult result;

    public UserRegistrationService(UserRegistrationDto userDto, UserService userService) {
        this.userDto = userDto;
        this.userService = userService;
        main();
    }

    private void main(){
        fieldFilledCheck(this.userDto.getFirstName(), "firstName");
        fieldFilledCheck(this.userDto.getLastName(), "lastName");
        fieldFilledCheck(this.userDto.getUsername(), "username");
        fieldFilledCheck(this.userDto.getEmail(), "email");
        fieldFilledCheck(this.userDto.getPassword(), "password");
        fieldFilledCheck(this.userDto.getConfirmPassword(), "confirmPassword");
        existingEmailCheck();
        existingUsernameCheck();
        samePasswordCheck();
    }

    private void fieldFilledCheck(String fieldVal, String fieldName){
        if (fieldVal.isEmpty()){
            this.result.rejectValue(fieldName, null, "This field cannot be empty.");
        }
    }

    private void existingEmailCheck(){
        if (userService.findByEmail(userDto.getEmail()) != null) {
            this.result.rejectValue("email",null, "There is already an account registered with that email");
        }
    }

    private void existingUsernameCheck(){
        if (userService.findByUsername(userDto.getUsername()) != null) {
            this.result.rejectValue("username",null, "There is already an account registered with that username");
        }
    }

    private void samePasswordCheck(){
        if(!userDto.getPassword().equalsIgnoreCase(userDto.getConfirmPassword())){
            this.result.rejectValue("confirmPassword",null, "Your entered passwords do not match.");
        }
    }

    public BindingResult getResult() {
        return result;
    }
}
