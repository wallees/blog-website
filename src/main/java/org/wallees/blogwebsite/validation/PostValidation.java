package org.wallees.blogwebsite.validation;

import org.springframework.validation.BindingResult;
import org.wallees.blogwebsite.model.Post;

public class PostValidation {

    Post post;
    BindingResult result;

    public PostValidation(Post post, BindingResult result){
        this.post = post;
        this.result = result;
        main();
    }

    private void main(){
        fieldFilledCheck(post.getBody(), "body");
        fieldFilledCheck(post.getTitle(), "title");
    }

    private void fieldFilledCheck(String fieldVal, String fieldName){
        if (fieldVal.isEmpty()){
            this.result.rejectValue(fieldName, null, "This field cannot be empty.");
        }
    }

    public BindingResult getResult() {
        return result;
    }
}
