package com.sparta.todolist.domain.todo.service;

import com.sparta.todolist.domain.member.entity.Member;
import com.sparta.todolist.domain.todo.dto.CreateRequestDto;
import com.sparta.todolist.domain.todo.dto.TodoResponseDto;
import com.sparta.todolist.domain.todo.dto.UpdateRequestDto;
import com.sparta.todolist.domain.todo.entity.Todo;
import com.sparta.todolist.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;




    @Transactional
    public TodoResponseDto createTodo(CreateRequestDto todoRequestDto, Member member) {
        Todo todo = new Todo(todoRequestDto.getTitle(), todoRequestDto.getContents(), member);
        todoRepository.save(todo);
        return new TodoResponseDto(todo);
    }

    public TodoResponseDto getTodo() {
        return (TodoResponseDto) todoRepository.findAll().stream().map(TodoResponseDto::new);
    }

    @Transactional
    public TodoResponseDto updateTodo(Long todoId, UpdateRequestDto requestDto, Member member) {
        Todo updatedTodo = todoRepository.findById(todoId).orElseThrow(() ->
                new IllegalArgumentException("해당 일정이 존재하지 않습니다."));

        if (!updatedTodo.getId().equals(member.getId())) {
            throw new SecurityException("수정할 권한이 없습니다.");
        }
        updatedTodo.update(requestDto.getTitle(), requestDto.getContents());

        return new TodoResponseDto(updatedTodo);
    }

    public void deleteTodo(Long todoId, Member member) {
        Todo deletedTodo = todoRepository.findById(todoId).orElseThrow(() ->
                new IllegalArgumentException("해당 일정은 존재하지 않습니다"));
        if (!deletedTodo.getId().equals(member.getId())) {
            throw new SecurityException("수정할 권한이 없습니다.");
        }

        todoRepository.delete(deletedTodo);

    }
}
