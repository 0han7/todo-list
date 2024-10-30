package com.sparta.todolist.domain.member.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor // for JPA
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String passowrd;

    
    @Email
    @Column(nullable = false)
    private String email;

    public Member(String name, String password, String email) {
        this.name = name;
        this.passowrd = password;
        this.email = email;
    }

    public void update(String name, String passowrd) {
        this.name = name;
        this.passowrd = passowrd;
    }
}
