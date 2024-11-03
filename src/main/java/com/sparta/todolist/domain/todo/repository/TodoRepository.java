package com.sparta.todolist.domain.todo.repository;

import com.sparta.todolist.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Collection<Todo> findAllByMemberId(Long memberId);
}
