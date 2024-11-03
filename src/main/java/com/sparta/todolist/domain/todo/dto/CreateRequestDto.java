package com.sparta.todolist.domain.todo.dto;

import lombok.Getter;

@Getter
public class CreateRequestDto {
    private String title;
    private String contents;
}
