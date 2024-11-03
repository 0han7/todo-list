package com.sparta.todolist.domain.comment.dto;

import com.sparta.todolist.domain.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class TodoCommentResponseDto {
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<CommentResponseDto> commentResponseDtoList;

    public TodoCommentResponseDto(Todo todo) {
        this.author = todo.getMember().getName();
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
        this.commentResponseDtoList = todo.getComments().stream().map(CommentResponseDto::new).toList();
    }
}
