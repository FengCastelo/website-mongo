package com.fengcastelo.webservice.Resources;

import com.fengcastelo.webservice.Model.Post;
import com.fengcastelo.webservice.Resources.util.URL;
import com.fengcastelo.webservice.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Post>> findById(@PathVariable String id) {
        Optional<Post> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Post>> searchAll(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            @RequestParam(value = "minDate", defaultValue = "") String minDate) {

        text = URL.decodeParam(text);

        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> list = service.fullSearch(text, min, max);

        return ResponseEntity.ok().body(list);
    }

}