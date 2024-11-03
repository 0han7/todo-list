package com.sparta.todolist.domain.comment.service;

import com.sparta.todolist.domain.comment.dto.*;
import com.sparta.todolist.domain.comment.entity.Comment;
import com.sparta.todolist.domain.comment.repository.CommentRepository;
import com.sparta.todolist.domain.member.entity.Member;
import com.sparta.todolist.domain.todo.entity.Todo;
import com.sparta.todolist.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    public CommentResponseDto createComment(Long todoId, CommentRequestDto commentRequestDto, Member member) {
        String contents = commentRequestDto.getContents();

        Todo todo = todoRepository.findById(todoId).orElseThrow(() ->
                new IllegalArgumentException("해당 일정을 찾을 수 었습니다"));

        Comment comment = new Comment(commentRequestDto.getContents(), todo, member);
        commentRepository.save(comment);
        return new CommentResponseDto(comment);
    }

    public TodoCommentResponseDto getComment(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() ->
                new IllegalArgumentException("해당 일정을 찾을 수 없습니다."));

        return new TodoCommentResponseDto(todo);
    }

    @Transactional
    public UpdateResponseDto updateComment(Long todoId, Long commentId, UpdateRequestDto requestDto, Member member) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() ->
                new IllegalArgumentException("해당 일정을 찾을 수 었습니다"));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글을 찾을 수 었습니다."));


        if (!comment.getMember().getId().equals(member.getId())) {
            throw new SecurityException("본인의 댓글만 수정할 수 있습니다.");
        }

            String updatedContents = requestDto.getContents();
            comment.update(updatedContents);


            commentRepository.save(comment);

            return new UpdateResponseDto(updatedContents);

    }

    @Transactional
    public void deleteComment(Long todoId, Long commentId, Member member) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() ->
                new IllegalArgumentException("해당 일정을 찾을 수 었습니다"));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글을 찾을 수 었습니다."));

        if (!comment.getMember().getId().equals(member.getId())) {
            throw new SecurityException("본인의 댓글만 삭제할 수 있습니다.");
        }
        commentRepository.delete(comment);
    }
}

