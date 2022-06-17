package org.wallees.blogwebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.model.User;
import org.wallees.blogwebsite.repository.PostRepository;
import org.wallees.blogwebsite.repository.UserRepository;
import org.wallees.blogwebsite.service.UserService;

//@Component
public class DataLoader {

    private PostRepository postRepository;

    private UserRepository userRepository;

    private UserService userService;

    @Autowired
    public DataLoader(PostRepository postRepository, UserRepository userRepository, UserService userService){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        LoadUsers();
        LoadPosts();
    }

    private void LoadUsers(){
        //Preloaded client-side user passwords = 'testpassword'
        userRepository.save(new User("acruz", "acruz@gmail.com", "$2a$10$/3HV/B4dOlx3nPpDZPG.KeYxS/AcHtTync2rfeC3ZynwVeOdDLsXW", "Amber", "Cruz"));
        userRepository.save(new User("prallings", "prallings@gmail.com",  "$2a$10$/3HV/B4dOlx3nPpDZPG.KeYxS/AcHtTync2rfeC3ZynwVeOdDLsXW", "Patrick", "Rallings"));
        userRepository.save(new User("creale", "creale@gmail.com", "$2a$10$/3HV/B4dOlx3nPpDZPG.KeYxS/AcHtTync2rfeC3ZynwVeOdDLsXW", "Colin", "Reale"));
        userRepository.save(new User("janderson", "janderson@gmail.com", "$2a$10$/3HV/B4dOlx3nPpDZPG.KeYxS/AcHtTync2rfeC3ZynwVeOdDLsXW", "Joseph", "Anderson"));
    }

    private void LoadPosts(){
        postRepository.save(new Post(
                userService.findByUsername("acruz"), "Developer Dynamic", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        ));
        postRepository.save(new Post(
                userService.findByUsername("prallings"), "Sorted Craze", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ));
        postRepository.save(new Post(
                userService.findByUsername("creale"), "CSS grid", "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
        ));
        postRepository.save(new Post(
                userService.findByUsername("prallings"), "Injection Hipchat", "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        ));
        postRepository.save(new Post(
                userService.findByUsername("janderson"), "Asynchronous Team-Player", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore."
        ));
    }

}
