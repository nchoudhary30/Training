package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    List<User> users = new ArrayList<>();


    @GetMapping("/user")
    @CrossOrigin("*")
    public List<User> printUser(){
        return users;
    }
    @GetMapping("/users")
    public List<User> printUser(@RequestParam String username) {
        String url = "https://api.github.com/users/" + username;
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(url, User.class);
        users.add(user);
        return users;
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        users.add(user);
//        user.setFirstname("Nikhil");
        return users.get(0);
    }

    @DeleteMapping("/user/{id}")
    public List<User> deleteUser(@PathVariable("id") int id) {
        users = users.stream().filter(user -> user.getId() != id).collect(Collectors.toList());
        return users;
    }

    @PutMapping("/user/{id}")
    public List<User> updateUser(@Valid @RequestBody User user, @PathVariable("id") int id) {
        users = users.stream().peek(u -> {
            if (u.getId() == id) {
                if(!(user.getRole()==null)) u.setRole(user.getRole());
                if(!(user.getFirstname()==null)) u.setFirstname(user.getFirstname());
                if(!(user.getLastname()==null)) u.setLastname(user.getLastname());
                if(!(user.getEmail()==null)) u.setEmail(user.getEmail());
            }
        }).collect(Collectors.toList());

        return users;
    }

    public long add(long x, long y){
        return x+y;
    }

}
