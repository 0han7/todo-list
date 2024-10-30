package com.sparta.todolist.domain.todo.controller;

import com.sparta.todolist.domain.member.entity.Member;
import com.sparta.todolist.domain.todo.dto.CreateRequestDto;
import com.sparta.todolist.domain.todo.dto.TodoResponseDto;
import com.sparta.todolist.domain.todo.dto.UpdateRequestDto;
import com.sparta.todolist.domain.todo.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody CreateRequestDto todoRequestDto, HttpServletRequest request) {

        Member member = (Member) request.getAttribute("member");
        TodoResponseDto todoResponseDto = todoService.createTodo(todoRequestDto, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoResponseDto);
    }

    @GetMapping
    public ResponseEntity<TodoResponseDto> getTodo() {
        TodoResponseDto todoResponseDto = todoService.getTodo();
        return ResponseEntity.status(HttpStatus.OK).body(todoResponseDto);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TodoResponseDto> updateTodo(@PathVariable Long todoId,
                                                      @RequestBody UpdateRequestDto requestDto,
                                                      HttpServletRequest request) {
        Member member = (Member) request.getAttribute("member");
        TodoResponseDto responseDto = todoService.updateTodo(todoId, requestDto, member);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long todoId,
                                             HttpServletRequest request) {
        Member member = (Member) request.getAttribute("member");
        todoService.deleteTodo(todoId, member);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("회원 탈퇴 완료");
    }
}