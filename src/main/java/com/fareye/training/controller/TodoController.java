package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TodoController {
    public static List<Todo> todos = new ArrayList<>();

    @GetMapping("/all")
    public List<Todo> showAll(){
        return todos;
    }


    @PostMapping("/todo")
    public List<Todo> create(@Valid @RequestBody Todo data){
        todos.add(data);
        return todos;
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable("id") int id){
        todos = todos.stream().filter(todo -> todo.getId() != id).collect(Collectors.toList());
    }

    @PutMapping("todo/{id}")
    public void updateTodo(@Valid @RequestBody Todo todo, @PathVariable("id") int id){
        todos = todos.stream().map(temp -> {
            if(temp.getId()==id){
                temp.setBody(todo.getBody());
                temp.setTitle(todo.getTitle());
            }
            return temp;
        }).collect(Collectors.toList());
    }


}
