package com.sparta.todolist.domain.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SignupRequsetDto {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @Email
    private String email;
}
