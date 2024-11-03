package com.sparta.todolist.domain.comment.controller;

import com.sparta.todolist.domain.comment.dto.*;
import com.sparta.todolist.domain.comment.service.CommentService;
import com.sparta.todolist.domain.config.JwtUtil;
import com.sparta.todolist.domain.member.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todo/{todoId}/comments")
public class CommentController {


    private final CommentService commentService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable Long todoId,
                                                            @RequestBody @Valid CommentRequestDto commentRequestDto,
                                                            HttpServletRequest request) {

        Member member = (Member) request.getAttribute("member");
        CommentResponseDto commentResponseDto = commentService.createComment(todoId, commentRequestDto, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponseDto);
    }

    @GetMapping
    public ResponseEntity<TodoCommentResponseDto> getComment(@PathVariable Long todoId) {

        TodoCommentResponseDto responseDto = commentService.getComment(todoId);
        return ResponseEntity.ok(responseDto);
    }


    @PutMapping("/{commentId}")
    public ResponseEntity<UpdateResponseDto> updateComment(@PathVariable Long todoId,
                                                           @PathVariable Long commentId,
                                                           @RequestBody @Valid UpdateRequestDto requestDto,
                                                           HttpServletRequest request) {
        Member member = (Member) request.getAttribute("member");
        UpdateResponseDto updateResponseDto = commentService.updateComment(todoId, commentId, requestDto, member);
        return ResponseEntity.status(HttpStatus.OK).body(updateResponseDto);
    }


    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long todoId,
                                                @PathVariable Long commentId,
                                                HttpServletRequest request) {

        Member member = (Member) request.getAttribute("member");
        commentService.deleteComment(todoId, commentId, member);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("댓글 삭제 완료");
    }

}
