package com.todolist.service;

import com.todolist.entity.Todo;
import com.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

@ExtendWith(value = MockitoExtension.class)
// Mockito 가 제공하는 JUnit5 확장을 적용하여 테스트 클래스나 메서드에서 Mockito 사용 가능
public class TodoServiceTest {

    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    private Todo todo;

    @Test

    public void createTodoTest() {
        Todo todo = new Todo(
                1L,
                "공부하기",
                3,
                false
        );

        given(todoRepository.save(Mockito.any(Todo.class))).willReturn(todo);

        Todo result = todoService.createTodo(todo);

        assertThat(result.getTitle(), is(equalTo(todo.getTitle())));
    }

    @Test
    public void findAllTest() {
        List<Todo> todoList = List.of(
                new Todo(
                        1L,
                        "공부하기",
                        1,
                        false
        ),
                new Todo(
                        2L,
                        "운동하기",
                        2,
                        false
                ),
                new Todo(
                        3L,
                        "책읽기",
                        3,
                        false
                )
        );

        given(todoRepository.findAll()).willReturn(todoList);

        List<Todo> result = todoService.findTodos();

        assertThat(result.size(), is(equalTo(todoList.size())));

        assertThat(result.get(0).getTitle(), is(equalTo(todoList.get(0).getTitle())));

    }

    @Test
    public void findTest() {
        Optional<Todo> todo = Optional.of(
                new Todo(
                        1L,
                        "공부하기",
                        3,
                        false
                )
        );

        given(todoRepository.findById(Mockito.anyLong())).willReturn(todo);

        Todo result = todoService.findTodo(1L);

        assertThat(result.getTitle(), is(equalTo((todo.orElseThrow().getTitle()))));
    }

    @Test
    public void updateTest() {
        Optional<Todo> todo = Optional.of(
                new Todo(
                        1L,
                        "공부하기",
                        3,
                        false
                )
        );

        Todo save = new Todo(
                1L,
                "운동하기",
                3,
                false
        );

        given(todoRepository.findById(Mockito.anyLong())).willReturn(todo);
        given(todoRepository.save(Mockito.any(Todo.class))).willReturn(save);

        Todo update = new Todo();
        update.setTitle("운동하기");

        Todo result = todoService.updateTodo(update, 1L);

        assertThat(result.getTitle(), is(equalTo(update.getTitle())));
    }


}
