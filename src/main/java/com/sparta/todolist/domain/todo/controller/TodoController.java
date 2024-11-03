package com.sparta.todolist.domain.todo.controller;

import com.sparta.todolist.domain.member.entity.Member;
import com.sparta.todolist.domain.todo.dto.CreateRequestDto;
import com.sparta.todolist.domain.todo.dto.TodoResponseDto;
import com.sparta.todolist.domain.todo.dto.UpdateRequestDto;
import com.sparta.todolist.domain.todo.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody CreateRequestDto requestDto, HttpServletRequest request) {

        Member member = (Member) request.getAttribute("member");
        TodoResponseDto todoResponseDto = todoService.createTodo(requestDto, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoResponseDto);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<List<TodoResponseDto>> getTodo(@PathVariable Long memberId) {
        List<TodoResponseDto> todoResponseDto = todoService.getTodo(memberId);
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