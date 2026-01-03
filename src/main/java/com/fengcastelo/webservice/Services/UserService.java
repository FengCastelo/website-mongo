package com.fengcastelo.webservice.Services;

import com.fengcastelo.webservice.Model.User;
import com.fengcastelo.webservice.Repositories.UserRepository;

import com.fengcastelo.webservice.Services.exception.ObjectNotFoundException;
import com.fengcastelo.webservice.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
