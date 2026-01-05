package com.fengcastelo.webservice.config;

import com.fengcastelo.webservice.Model.Post;
import com.fengcastelo.webservice.Model.User;
import com.fengcastelo.webservice.Repositories.PostRepository;
import com.fengcastelo.webservice.Repositories.UserRepository;
import com.fengcastelo.webservice.dtos.AuthorDTO;
import com.fengcastelo.webservice.dtos.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(List.of(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2025 10:52:00"), "Let's Travel", "I'm going to travel to São Paulo. xoxo", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2025 16:30:00"), "Good Morning", "I woke up happy today", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Have a Good travel, bro!", sdf.parse("21/03/2025 11:02:00"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Enjoy it!", sdf.parse("21/03/2025 10:58:00"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Have a great day!", sdf.parse("23/03/2025 16:52:00"), new AuthorDTO(bob));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(List.of(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
