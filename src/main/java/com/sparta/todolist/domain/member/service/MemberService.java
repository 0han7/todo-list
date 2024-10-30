package com.sparta.todolist.domain.member.service;

import com.sparta.todolist.domain.config.JwtUtil;
import com.sparta.todolist.domain.config.PassowordEncoder;
import com.sparta.todolist.domain.member.dto.*;
import com.sparta.todolist.domain.member.entity.Member;
import com.sparta.todolist.domain.member.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PassowordEncoder passowordEncoder;
    private final JwtUtil jwtUtil;
    private final EmailValidator emailValidator;



    public void signup(SignupRequsetDto requsetDto) {
        String name = requsetDto.getName();
        String password = passowordEncoder.encode(requsetDto.getPassword());

        String email = requsetDto.getEmail();
        Optional<Member> checkEmail = memberRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 Email입니다.");
        }

        Member member = new Member(name, password, email);
        memberRepository.save(member);
    }

    public void login(LoginRequestDto requestDto, HttpServletResponse response) {
        String email = requestDto.getEmail();
        String password = requestDto.getPassowrd();

        Member member = memberRepository.findByEmail(email).orElseThrow(() ->
                new IllegalArgumentException("해당 유저는 존재하지 않습니다."));

        if (!passowordEncoder.matches(password, member.getPassowrd())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtUtil.createToken(member.getEmail());
        jwtUtil.addJwtToCookie(token, response);
    }

    @Transactional
    public MemberResponseDto updateMember(Long memberId, UpdateMemberRequestDto requsetDto, Member member) {
        Member updatedMember = memberRepository.findById(memberId).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        if (!memberId.equals(member.getId())) {
            throw new SecurityException("수정할 권한이 없습니다.");

        }

        if (!passowordEncoder.matches(requsetDto.getPassword(), member.getPassowrd())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        if (passowordEncoder.matches((requsetDto.getUpdatedPassword()), member.getPassowrd())) {
            throw new IllegalArgumentException("현재 비밀번호와 동일한 번호로 수정할 수 없스니다.");
        }

        String updatedPassword = passowordEncoder.encode(requsetDto.getUpdatedPassword());
        updatedMember.update(requsetDto.getName(), updatedPassword);
        memberRepository.save(updatedMember);

        return new MemberResponseDto(updatedMember);
    }


    public void deleteMember(String memberId, DeleteRequestDto requestDto, Member member) {
        Member deleteMember = memberRepository.findById(memberId).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        if (!memberId.equals(member.getId())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        memberRepository.delete(deleteMember);
    }

}
