package me.dio.controller;

import me.dio.domain.model.ToDo;
import me.dio.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/todolist")
public class ToDoController {

    private final ToDoService service;
    public ToDoController(ToDoService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable Long id) {
        var toDo = service.findById(id);
        return ResponseEntity.ok(toDo);
    }

    @PostMapping
    public ResponseEntity<ToDo> create(@RequestBody ToDo toDoToCreate) {
        var toDoCreated = service.create(toDoToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(toDoCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(toDoCreated);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ToDo>> getAll() {
        var toDos = service.getAll();
        return ResponseEntity.ok(toDos);
    }

    @PutMapping
    public ResponseEntity<ToDo> update(@RequestBody ToDo toDoToUpdate) {
        var toDoUpdated = service.update(toDoToUpdate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(toDoUpdated.getId())
                .toUri();
        return ResponseEntity.created(location).body(toDoUpdated);
    }
}
