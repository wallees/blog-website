package org.wallees.blogwebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.repository.PostRepository;
import org.wallees.blogwebsite.repository.UserRepository;

@Component
public class DataLoader {

    private PostRepository postRepository;

    private UserRepository userRepository;

    @Autowired
    public DataLoader(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        LoadPosts();
        LoadUsers();
    }

    private void LoadPosts(){
        postRepository.save(new Post(
                1, "Developer Dynamic", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        ));
        postRepository.save(new Post(
                2, "Sorted Craze", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ));
        postRepository.save(new Post(
                1, "CSS grid", "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
        ));
        postRepository.save(new Post(
                3, "Injection Hipchat", "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        ));
        postRepository.save(new Post(
                3, "Asynchronous Team-Player", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore."
        ));
    }

    private void LoadUsers(){
        userRepository.save(new User("acruz", "acruz@gmail.com", "temppass", "Amber", "Cruz"));
        userRepository.save(new User("prallings", "prallings@gmail.com",  "temppass", "Patrick", "Rallings"));
        userRepository.save(new User("creale", "creale@gmail.com", "temppass", "Colin", "Reale"));
        userRepository.save(new User("janderson", "janderson@gmail.com", "temppass", "Joseph", "Anderson"));
    }
}
