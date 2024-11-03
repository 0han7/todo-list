package com.sparta.todolist.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentRequestDto  {
    @NotBlank
    private String contents;

}
