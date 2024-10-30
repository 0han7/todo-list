package com.sparta.todolist.domain.member.controller;

import com.sparta.todolist.domain.member.dto.*;
import com.sparta.todolist.domain.member.entity.Member;
import com.sparta.todolist.domain.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberCotroller {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequsetDto requsetDto) {
        memberService.signup(requsetDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto requestDto, HttpServletResponse response) {
        memberService.login(requestDto, response);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("로그인 성공");
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long memberId,
                                                          @RequestBody UpdateMemberRequestDto requsetDto,
                                                          HttpServletRequest request) {
        Member member = (Member) request.getAttribute("member");
        MemberResponseDto responseDto = memberService.updateMember(memberId, requsetDto, member);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDto);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable String memberId,
                                               @RequestBody DeleteRequestDto requestDto,
                                               HttpServletRequest request) {
        Member member = (Member) request.getAttribute("member");
        memberService.deleteMember(memberId, requestDto, member);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("회원 탈퇴 완료");

    }
}

