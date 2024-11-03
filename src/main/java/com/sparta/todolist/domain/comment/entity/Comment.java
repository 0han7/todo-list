package com.sparta.todolist.domain.comment.entity;

import com.sparta.todolist.domain.common.TimeStamped;
import com.sparta.todolist.domain.member.entity.Member;
import com.sparta.todolist.domain.todo.entity.Todo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Comment extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String contents;

    @Column(nullable = false)
    private String name;


    // 작성자와 댓글 = 다 대 일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;


    // 게시글과 댓글 = 다 대 일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    public Comment(String contents, Todo todo, Member member) {
        this.contents = contents;
        this.todo= todo;
        this.member = member;
        this.name = member.getName();
    }

    public void update(String contents) {
        this.contents = contents;

    }
}
