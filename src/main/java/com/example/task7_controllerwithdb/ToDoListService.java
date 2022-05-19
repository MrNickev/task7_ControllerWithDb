package com.example.task7_controllerwithdb;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {

    private final ToDoRepo repo;
    private final ModelMapper modelMapper;

    public ToDoListService(ToDoRepo repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    public List<ToDoListDTO> getAllToDoList() {
        return MapperUtil.convertList(repo.findAll(), this::convertToDto);
    }

    private ToDoListDTO convertToDto(ToDoList todo) {
        var todoDto = modelMapper.map(todo, ToDoListDTO.class);
        todoDto.setEventsDto(todo.getEventList().stream().map(Event::getName).toList());
        return todoDto;
    }

    private ToDoList convertFromDto(ToDoListDTO todo) {
        var todoDto = modelMapper.map(todo, ToDoList.class);
        todoDto.setEventList(todo.getEventsDto().stream().map(Event::new).toList());
        return todoDto;
    }

    public void saveTodo(ToDoListDTO toDoList) {
        var todo = convertFromDto(toDoList);
        repo.save(todo);
    }
}
