package me.dio.service;

import me.dio.domain.model.ToDo;

import java.util.List;

public interface ToDoService {

    ToDo findById(Long id);
    ToDo create(ToDo toDoToBeCreated);
    ToDo update(ToDo toDoToBeUpdated);
    List<ToDo> getAll();
}
