package com.sparta.todolist.domain.todo.service;

import com.sparta.todolist.domain.member.entity.Member;
import com.sparta.todolist.domain.member.repository.MemberRepository;
import com.sparta.todolist.domain.todo.dto.CreateRequestDto;
import com.sparta.todolist.domain.todo.dto.TodoResponseDto;
import com.sparta.todolist.domain.todo.dto.UpdateRequestDto;
import com.sparta.todolist.domain.todo.entity.Todo;
import com.sparta.todolist.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;





    @Transactional
    public TodoResponseDto createTodo(CreateRequestDto requestDto, Member member) {
        Todo todo = new Todo(requestDto, member);
        todoRepository.save(todo);
        return new TodoResponseDto(todo);
    }


    public List<TodoResponseDto> getTodo(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        return todoRepository.findAllByMemberId(memberId).stream().map(TodoResponseDto::new).toList();
    }

    @Transactional
    public TodoResponseDto updateTodo(Long todoId, UpdateRequestDto requestDto, Member member) {
        Todo updatedTodo = todoRepository.findById(todoId).orElseThrow(() ->
                new IllegalArgumentException("해당 일정이 존재하지 않습니다."));

        if (!updatedTodo.getMember().getId().equals(member.getId())) {
            throw new SecurityException("수정할 권한이 없습니다.");
        }
        updatedTodo.update(requestDto.getTitle(), requestDto.getContents());
        todoRepository.saveAndFlush(updatedTodo);
        return new TodoResponseDto(updatedTodo);
    }

    @Transactional
    public void deleteTodo(Long todoId, Member member) {
        Todo deletedTodo = todoRepository.findById(todoId).orElseThrow(() ->
                new IllegalArgumentException("해당 일정은 존재하지 않습니다"));
        if (!deletedTodo.getMember().getId().equals(member.getId())) {
            throw new SecurityException("수정할 권한이 없습니다.");
        }

        todoRepository.delete(deletedTodo);

    }
}
