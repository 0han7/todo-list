package com.sparta.todolist.domain.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateRequestDto {
    @NotBlank
    private String title;

    @NotBlank
    private String contents;
}
