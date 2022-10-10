package com.fareye.training.controller;

import com.fareye.training.model.User;
import com.fareye.training.util.HashPassword;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    List<User> users = new ArrayList<>();
    @GetMapping("/user")
    public List<User> printUser(@RequestParam String username){
        String url = "https://api.github.com/users/" + username;
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(url, User.class);
        users.add(user);
        return users;
    }

    @PostMapping("/user")
    public List<User> createUser(@RequestBody User user){
        users.add(user);
        return users;
    }

    @DeleteMapping("/user/{id}")
    public List<User> deleteUser(@PathVariable("id") int id){
        users=users.stream().filter(user->user.getId()!=id).collect(Collectors.toList());
        return users;
    }

    @PutMapping("/user/{id}")
    public List<User> updateUser(@RequestBody User user, @PathVariable("id") int id){
        users = users.stream().peek(u -> {
            if(u.getId()==id){
                u.setRole(user.getRole());
                u.setFirstname(user.getFirstname());
                u.setLastname(user.getLastname());
                u.setEmail(user.getEmail());
            }
        }).collect(Collectors.toList());

        return users;
    }

}
