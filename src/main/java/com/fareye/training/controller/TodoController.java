package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    List<Todo> todo = new ArrayList<>();

    @GetMapping("/all")
    public List<Todo> showall(){
        return todo;
    }

    @GetMapping("/todouser")
    public List<Todo> showall(@RequestParam String title){
        return todo;
    }

    @PostMapping("/display")
    public List<Todo> create(@RequestBody Todo data){
        todo.add(data);
        return todo;
    }


}
