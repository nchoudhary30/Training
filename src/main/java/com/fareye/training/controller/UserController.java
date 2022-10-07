package com.fareye.training.controller;

import com.fareye.training.model.User;
import com.fareye.training.util.HashPassword;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/abcd")
    public String hello(@RequestParam String name){
        return "Hello" + name;
    }
    List<User> users = new ArrayList<>();

    @PostMapping("/user")
    public List<User> createUser(@RequestBody User user){

        users.add(user);
        return users;
    }

}
