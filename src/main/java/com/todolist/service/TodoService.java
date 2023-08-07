package com.todolist.service;

import com.todolist.entity.Todo;
import com.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {

        this.todoRepository = todoRepository;
    }

    public Todo createTodo (Todo todo) {
        return todoRepository.save(todo);

    }

    public List<Todo> findTodos() {

        return todoRepository.findAll();
    }

    public Todo findTodo(long id) {
        Optional<Todo> findTodo = todoRepository.findById(id);

        Todo todo = findTodo.orElse(new Todo());

        return todo;

    }

    public Todo updateTodo(Todo todo, long id) {
        Todo seekTodo = findTodo(id);
        Optional.ofNullable(todo.getTodoOrder())
                .ifPresent(seekTodo::setTodoOrder);
        Optional.ofNullable(todo.getTitle())
                .ifPresent(seekTodo::setTitle);
        Optional.ofNullable(todo.isCompleted())
                .ifPresent(seekTodo::setCompleted);

        return todoRepository.save(seekTodo);

    }

    public void deleteAllTodo() {
        todoRepository.deleteAll();
    }

    public void deleteTodo(long id) {
        todoRepository.deleteById(id);
    }

}
