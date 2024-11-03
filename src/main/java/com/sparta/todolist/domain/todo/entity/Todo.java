package com.sparta.todolist.domain.todo.entity;

import com.sparta.todolist.domain.comment.entity.Comment;
import com.sparta.todolist.domain.common.TimeStamped;
import com.sparta.todolist.domain.member.entity.Member;
import com.sparta.todolist.domain.todo.dto.CreateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();




    public Todo(CreateRequestDto requestDto, Member member) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.member = member;

    }


    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
