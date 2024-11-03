package com.sparta.todolist.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DeleteRequestDto {
    @NotBlank
    private String password;
}
