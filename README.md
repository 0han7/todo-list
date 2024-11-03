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
* ResponseEntity 클래스 사용
* Validation 추가
* TimeStamped 클래스를 사용하여 createdAt, updatedAt 상속


### 2. 토큰 기반의 인증
* JWT토큰을 이용한 로그인 구현
* 인증 필터 (authFilter)


<br>

## 📋API 명세서- 일정 관리 시스템
#### 노션 API 명세서 URL : https://giddy-ox-904.notion.site/API-1214bd51dfda800cae6aec06860dc56d?pvs=4

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

---

위와 같은 형식으로 로그인 및 회원가입 API 명세를 작성하여 참고하시면 됩니다.

추가적인 도움이 필요하시면 [GPT Online](https://gptonline.ai/ko/)을 방문해 주세요.


## ERM
![스크린샷 2024-10-17 111056](https://github.com/user-attachments/assets/09913660-d354-4b02-ba3c-8fd18470ee33)


