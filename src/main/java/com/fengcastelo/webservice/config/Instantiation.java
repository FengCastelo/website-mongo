package com.fengcastelo.webservice.config;

import com.fengcastelo.webservice.Model.Post;
import com.fengcastelo.webservice.Model.User;
import com.fengcastelo.webservice.Repositories.PostRepository;
import com.fengcastelo.webservice.Repositories.UserRepository;
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

        System.out.println("🚨 CONFIG RODOU 🚨");
        System.out.println("COUNT ANTES: " + userRepository.count());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2025"), "Let's Travel", "I'm going to travel to São Paulo. xoxo", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2025"), "Good Morning", "I woke up happy today", maria);

        userRepository.saveAll(List.of(maria, alex, bob));
        postRepository.saveAll(List.of(post1, post2));

        System.out.println("COUNT DEPOIS: " + userRepository.count());
    }
}
