package com.sparta.todolist.domain.todo.repository;

import com.sparta.todolist.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
