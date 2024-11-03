package com.sparta.todolist.domain.comment.dto;

import com.sparta.todolist.domain.comment.entity.Comment;
import lombok.Getter;

@Getter
public class UpdateResponseDto {

    private String contents;

    public UpdateResponseDto(String comment) {
        this.contents = comment;
    }
}
