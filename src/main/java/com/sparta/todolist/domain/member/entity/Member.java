package com.sparta.todolist.domain.member.entity;

import com.sparta.todolist.domain.common.TimeStamped;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor // for JPA
public class Member extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private String email;

    public Member(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void update(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
