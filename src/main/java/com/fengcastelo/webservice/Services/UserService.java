package com.fengcastelo.webservice.Services;

import com.fengcastelo.webservice.Model.User;
import com.fengcastelo.webservice.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
