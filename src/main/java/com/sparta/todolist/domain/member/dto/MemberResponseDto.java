package com.sparta.todolist.domain.member.dto;

import com.sparta.todolist.domain.member.entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberResponseDto {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime updatedAt;


    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.updatedAt = member.getUpdatedAt();
    }
}
