package com.example.task7_controllerwithdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ToDoListDTO {

    @NotNull
    @Size(min = 1)
    private String name;

    @JsonProperty("events")
    @NotNull
    @Size(min = 1)
    private List<String> eventsDto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEventsDto() {
        return eventsDto;
    }

    public void setEventsDto(List<String> eventsDto) {
        this.eventsDto = eventsDto;
    }
}
