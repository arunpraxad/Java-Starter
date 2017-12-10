package com.example.demo.resource;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserResource {

    UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/all")
    List<User> getAllUser() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    List<User> saveUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }
}
