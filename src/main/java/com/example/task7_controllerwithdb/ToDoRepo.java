package com.example.task7_controllerwithdb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepo extends CrudRepository<ToDoList, Integer> {
    List<ToDoList> findAll();
}
