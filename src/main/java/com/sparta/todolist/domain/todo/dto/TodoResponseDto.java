package com.sparta.todolist.domain.todo.dto;

import com.sparta.todolist.domain.comment.dto.CommentResponseDto;
import com.sparta.todolist.domain.member.dto.MemberResponseDto;
import com.sparta.todolist.domain.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class TodoResponseDto {
    private Long id;
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
    }
}
