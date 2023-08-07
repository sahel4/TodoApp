package com.todolist.controller;


import com.todolist.dto.TodoDto;
import com.todolist.entity.Todo;
import com.todolist.mapper.TodoMapper;
import com.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }


    @PostMapping
    public ResponseEntity postTodo(@RequestBody TodoDto.Post todoPost) {
        Todo todo = todoService.createTodo(todoMapper.postToTodo(todoPost));

        return new ResponseEntity(todo, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity getTodo() {
        return new ResponseEntity<>(todoService.findTodos(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getTodos(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(todoService.findTodo(id), HttpStatus.OK);

    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity updateTodo(@PathVariable(name = "id") long id,
                                     @RequestBody TodoDto.Patch todoPatch) {
        return new ResponseEntity<>(todoService.updateTodo(
                todoMapper.patchToTodo(todoPatch), id), HttpStatus.OK);
    }



    @DeleteMapping
    public void deleteAllTodo() {
        todoService.deleteAllTodo();

    }

    @DeleteMapping(path = "/{id}")
    public void deleteTodo(@PathVariable(name = "id") long id) {
        todoService.deleteTodo(id);
    }
  }
