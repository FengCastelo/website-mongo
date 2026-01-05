package com.fengcastelo.webservice.Resources;

import com.fengcastelo.webservice.Model.Post;
import com.fengcastelo.webservice.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        List<Post> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Post>> findById(@PathVariable String id) {
        Optional<Post> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}