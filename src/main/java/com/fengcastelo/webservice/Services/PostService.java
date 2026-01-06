package com.fengcastelo.webservice.Services;

import com.fengcastelo.webservice.Model.Post;
import com.fengcastelo.webservice.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Optional<Post> findById(String id) {
        return repository.findById(id);
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }
}
