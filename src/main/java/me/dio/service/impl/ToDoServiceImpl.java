package me.dio.service.impl;

import me.dio.domain.model.ToDo;
import me.dio.domain.repository.ToDoRepository;
import me.dio.service.ToDoService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository repository;

    public ToDoServiceImpl(ToDoRepository repository){
        this.repository = repository;
    }

    @Override
    public ToDo findById(Long id) {
     return this.repository.findById(id).orElseThrow(NoSuchElementException::new);

    }

    @Override
    public ToDo create(ToDo toDoToBeCreated) {
        if(toDoToBeCreated == null || repository.existsById(toDoToBeCreated.getId())){
            throw new IllegalArgumentException("This ToDo already exists.");
        }
        return repository.save(toDoToBeCreated);
    }
}
