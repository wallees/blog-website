package org.wallees.blogwebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wallees.blogwebsite.model.Post;
import org.wallees.blogwebsite.repository.PostRepository;

@Component
public class DataLoader {
    private PostRepository postRepository;

    @Autowired
    public DataLoader(PostRepository postRepository){
        this.postRepository = postRepository;
        LoadPosts();
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
}
