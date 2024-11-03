# 내일배움캠프 스프링 8주차 개인 과제 

## 🖥️프로젝트 소개 
숙련 CRUD 기반의 테스트, 개선 과제입니다.

## 📆개발 기간
* 24.10.25 ~ 24.11.13

### 🖥️기술 스택
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">


## 📌주요 기능 

### 1. CRUD 개선
* ResponseEntity 클래스를 사용했습니다.
* Validation 추가했습니다.
* TimeStamped 추상 클래스를 사용하여 각 엔티티 상속했습니다.


### 2. 토큰 기반의 인증
* JWT토큰을 이용한 로그인 구현했습니다.
* 인증 필터 (authFilter)를 사용했습니다.


<br>

## 📋API 명세서- 일정 관리 시스템

### 일정
| 메서드   | URL                | 설명        | 요청 본문 (Request Body)                                                            | 응답 본문 (Response Body)                                                                                                                                                                                                                         | 응답 코드 |
|---------|--------------------|-------------|------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
| GET     | /api/todo/{memberId}       | 일정 조회   | 없음                                                                               | ```json [ { "id": 1, "이름": "홍길동", "제목": "물 마시기", "내용": "물 1L마시기", "createdAt": "등록일", "modifiedAt": "수정일" }, { "id": 2, "이름": "김무명", "제목": "물 마시기", "내용": "물 1L마시기", "createdAt": "등록일", "modifiedAt": "수정일" } ] ```                        | 200 OK   |
| POST    | /api/todo       | 일정 등록   | ```json { "username": "홍길동", "password": "1234567w", "title": "물 마시기", "contents": "물 1L 마시기" } ``` | ```json { "id": 1, "username": "홍길동", "password": "1234567w", "title": "물 마시기", "contents": "물 1L 마시기", "createdAt": "2024-10-16T16:19:49.9352444", "modifiedAt": "2024-10-16T16:19:49.9352444" } ```                                 | 200 OK   |
| PUT     | /api/todo/{todoId}  | 일정 수정   | ```json { "username": "홍길동 수정", "password": "1234567w", "title": "물 마시기 수정", "contents": "물 1L 마시기 수정" } ``` | ```json { "id": 1, "username": "홍길동 수정", "password": "1234567w", "title": "물 마시기 수정", "contents": "물 1L 마시기 수정", "createdAt": "2024-10-16T16:19:49.9352444", "modifiedAt": "2024-10-16T16:19:49.9352444" } ```                     | 200 OK   |
| DELETE  | /api/todo/{todoId}   | 일정 삭제   | 없음                                                       | 없음                                                                                                                                                                                                                        | 200 OK   |



### 댓글
| 메서드   | URL                | 설명        | 요청 본문 (Request Body)                                    | 응답 본문 (Response Body)                                                                                                                                                                                                 | 응답 코드 |
|---------|--------------------|-------------|------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
| GET     | /api/todo/{todoId}/comments        | 댓글 조회   | 없음                                                       | ```json [ { "id": 1, "username": "홍길동", "contents": "댓글테스트", "createdAt": "2024-00-00", "modifiedAt": "2024-00-00" }, { "id": 2, "username": "김무명", "contents": "댓글테스트", "createdAt": "2024-00-00", "modifiedAt": "2024-00-00" } ] ``` | 200 OK   |
| POST    | /api/todo/{todoId}/comments       | 댓글 생성   | ```json { "username": "홍길동", "contents": "댓글 테스트" } ``` | ```json { "id": 1, "username": "홍길동", "contents": "댓글테스트", "createdAt": "2024-00-00", "modifiedAt": "2024-00-00" } ```                                                                                             | 200 OK   |
| PUT     | /api/todo/{todoId}/comments/{commentId}   | 댓글 수정   | ```json { "username": "홍길동", "contents": "댓글 수정 테스트" } ``` | ```json { "id": 1, "username": "홍길동", "contents": "댓글 수정 테스트", "createdAt": "2024-00-00", "modifiedAt": "2024-00-00" } ```                                                                                       | 200 OK   |
| DELETE  | /api/todo/{todoId}/comments/{commentId}   | 댓글 삭제   | 없음                                                       | 없음                                                                                                                                                                                                                        | 200 OK   |



### 유저
| 메서드 | URL          | 설명            | 요청 본문 (Request Body)                        | 응답 본문 (Response Body)                                                                                                                                                                                                                                                                                                | 응답 코드 |
|--------|--------------|-----------------|-------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
| GET    | /api/members    | 유저 조회       | 없음                                            | ```json [ { "id": 1, "login": "jdjHong", "password": "1234567w", "username": "홍길동", "email": "jdjHong@email.com", "createdAt": "2024-10-16T16:47:52.0360414", "modifiedAt": "2024-10-16T16:47:52.0360414" }, { "id": 2, "login": "myKim", "password": "1234567w", "username": "김무명", "email": "myKim@email.com", "createdAt": "2024-10-16T16:47:52.0360414", "modifiedAt": "2024-10-16T16:47:52.0360414" } ] ``` | 200 OK   |
| PUT    | /api/members/{memberId} | 유저 수정      | ```json { "login": "jdjHong2", "password": "1234567w", "username": "홍길동", "email": "jdjHong@email.com" } ``` | ```json { "id": 1, "login": "jdjHong2", "password": "1234567w", "username": "홍길동", "email": "jdjHong@email.com", "createdAt": "2024-10-16T16:47:52.0360414", "modifiedAt": "2024-10-16T16:47:52.0360414" } ```                                                                                                                                              | 200 OK   |
| DELETE  | /api/members/{memberId}}   | 유저 삭제   | 없음                                                       | 없음                                                                                                                                                                                                                        | 200 OK   |
| POST   | /api/members/login  | 로그인       | ```json { "login": "jdjHong", "password": "1234567w" } ```                                                            | ```json { "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...", "userId": 1, "username": "홍길동" } ```                                                                   | 200 OK       |
| POST   | /api/members/signup | 회원가입     | ```json { "login": "jdjHong", "password": "1234567w", "username": "홍길동", "email": "jdjHong@email.com" } ```         | ```json { "id": 1, "login": "jdjHong", "username": "홍길동", "email": "jdjHong@email.com", "createdAt": "2024-10-16T16:47:52.0360414" } ```                              | 201 Created |



## ERM
![image](https://github.com/user-attachments/assets/c5bfe54f-d13e-48aa-b262-aba469a56f4b)



