package com.sparta.todolist.domain.comment.dto;

import com.sparta.todolist.domain.comment.entity.Comment;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateResponseDto {

    @NotBlank
    private String contents;

    public UpdateResponseDto(String comment) {
        this.contents = comment;
    }
}
