package com.example.task7_controllerwithdb;

import javax.persistence.*;
import java.util.List;

@Entity
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_do_id")
    private List<Event> eventList;

    public ToDoList() {
    }

    public ToDoList(String name, List<Event> eventList) {
        this.name = name;
        this.eventList = eventList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
