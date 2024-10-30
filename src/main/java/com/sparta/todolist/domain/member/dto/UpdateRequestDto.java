package com.sparta.todolist.domain.member.dto;

import lombok.Getter;

@Getter
public class UpdateRequestDto {
    private String name;
    private String password;
    private String updatedPassword;
}
