package com.todolist.mapper;

import com.todolist.dto.TodoDto;
import com.todolist.entity.Todo;
import org.springframework.stereotype.Component;

@Component // Spring 컨테이너가 이 클래스를 빈으로 관리
public class TodoMapper {
    public Todo postToTodo(TodoDto.Post todoPost) { //
        Todo todo = new Todo();
        todo.setTodoOrder(todoPost.getTodoOrder());
        todo.setCompleted(todoPost.isCompleted());
        todo.setTitle(todoPost.getTitle());
        
        return todo;

    }

    public Todo patchToTodo(TodoDto.Patch todoPatch) { //
        Todo todo = new Todo();
        todo.setTodoOrder(todoPatch.getTodoOrder());
        todo.setCompleted(todoPatch.isCompleted());
        todo.setTitle(todoPatch.getTitle());

        return todo;

    }
}
