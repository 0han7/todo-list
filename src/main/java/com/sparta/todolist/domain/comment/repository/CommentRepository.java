package com.sparta.todolist.domain.comment.repository;

import com.sparta.todolist.domain.comment.entity.Comment;
import com.sparta.todolist.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
