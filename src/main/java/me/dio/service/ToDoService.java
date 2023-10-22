package me.dio.service;

import me.dio.domain.model.ToDo;

public interface ToDoService {

    ToDo findById(Long id);
    ToDo create(ToDo toDoToBeCreated);
}
