package com.sparta.todolist.domain.todo.dto;

import com.sparta.todolist.domain.todo.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponseDto {
    private Long id;
    private String title;
    private String contents;

    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
    }
}
