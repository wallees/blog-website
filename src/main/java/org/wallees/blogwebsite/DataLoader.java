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
                1, "Developer Dynamic", "The CSV Linux is down, secure the public environment"
        ));
        postRepository.save(new Post(
                2, "Sorted Gulp", "So code-splitting the library won''t do anything, we need to lazy eval the greenfield LIFO convention!"
        ));
        postRepository.save(new Post(
                1, "CSS grid", "Queue val Chrome bubble sort key-value callback hell."
        ));
        postRepository.save(new Post(
                3, "Injection Hipchat", "Hacker News heap sort free as speech contribution killer app architecture."
        ));
        postRepository.save(new Post(
                3, "Asynchronous Team-Player", "Fullstack design waterfall Github duck typing a place for everything JVM view-model CSV. Ubuntu developer callback hell DSL YAML flexbox middleware killer app. Keycaps domain font native convention static progressive web app."
        ));
    }
}
