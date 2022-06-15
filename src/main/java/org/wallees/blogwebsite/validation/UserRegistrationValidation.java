package org.wallees.blogwebsite.validation;

import org.springframework.validation.BindingResult;
import org.wallees.blogwebsite.service.UserService;
import org.wallees.blogwebsite.web.UserRegistrationDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationValidation {

    UserRegistrationDto userDto;
    UserService userService;
    BindingResult result;

    public UserRegistrationValidation(UserRegistrationDto userDto, UserService userService, BindingResult result) {
        this.userDto = userDto;
        this.userService = userService;
        this.result = result;
        main();
    }

    private void main(){
        fieldFilledCheck(this.userDto.getFirstName(), "firstName");
        fieldFilledCheck(this.userDto.getLastName(), "lastName");
        fieldFilledCheck(this.userDto.getUsername(), "username");
        fieldFilledCheck(this.userDto.getEmail(), "email");
        fieldFilledCheck(this.userDto.getPassword(), "password");
        fieldFilledCheck(this.userDto.getConfirmPassword(), "confirmPassword");
        emailRegexCheck();
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

    private void emailRegexCheck(){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userDto.getEmail());
        if (!matcher.matches()){
            this.result.rejectValue("email",null, "This is not a valid email.");
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
