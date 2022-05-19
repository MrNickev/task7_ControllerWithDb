package com.example.task7_controllerwithdb;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {
    private final ToDoListService service;

    public Controller(ToDoListService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public List<ToDoListDTO> getAllToDoLists() {
        return service.getAllToDoList();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addToDoList(@RequestBody @Valid ToDoListDTO body) {
        service.saveTodo(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
