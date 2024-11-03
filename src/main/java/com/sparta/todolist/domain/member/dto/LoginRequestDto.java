package com.sparta.todolist.domain.member.dto;

import lombok.Getter;

@Getter
public class LoginRequestDto {

    private String email;
    private String password;
}
