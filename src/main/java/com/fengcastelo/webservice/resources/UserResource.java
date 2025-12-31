package com.fengcastelo.webservice.resources;

import com.fengcastelo.webservice.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User Maria = new User("123456", "maria@gmail.com", "Maria Silva");
        User Alex = new User("1230456", "alex@gmail.com", "Alex Green");
        return ResponseEntity.ok().body(new ArrayList<>(Arrays.asList(Maria, Alex)));
    }
}
