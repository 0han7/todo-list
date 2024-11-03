package com.sparta.todolist.domain.comment.dto;

import com.sparta.todolist.domain.comment.entity.Comment;
import com.sparta.todolist.domain.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CommentResponseDto {

    private Long id;
    private String name;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.name = comment.getName();
        this.content = comment.getContents();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();

    }

}
