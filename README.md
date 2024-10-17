

![image](https://github.com/user-attachments/assets/a3cb2f65-6ca7-4640-9636-8c71d5a9cb9a)




![image](https://github.com/user-attachments/assets/f4c13147-7960-441b-a8ce-c395f58d9a31)


# Spring-deep
프로젝트 개요

이 프로젝트는 사용자가 스케줄을 만들고 관리할 수 있는 스케줄 애플리케이션입니다. 

Spring Boot와 JPA를 사용하여 데이터 영속성을 처리하며, 다음과 같은 기능들을 제공합니다:

사용자 생성, 수정, 삭제

스케줄 생성, 수정, 삭제

스케줄에 댓글 추가

스케줄 목록 페이징 처리




Entity



Schedule

일정 정보를 저장하는 클래스입니다.

필드:

id: 일정 고유 식별자

username: 일정 작성 유저명

title: 일정 제목

content: 일정 내용

commentList: 해당 일정에 달린 댓글 리스트

userScheduleList: 일정 담당 유저 리스트

user: 일정 작성 유저


Comment

댓글 정보를 저장하는 클래스입니다.

필드:

id: 댓글 고유 식별자

content: 댓글 내용

username: 댓글 작성 유저명

schedule: 댓글이 달린 일정


User

유저 정보를 저장하는 클래스입니다.

필드:

id: 유저 고유 식별자

email: 유저 이메일

username: 유저명

schedules: 유저가 작성한 일정 리스트

userScheduleList: 유저와 일정 간의 다대다 관계를 관리하는 리스트

UserSchedule

설명: 사용자와 스케줄 간의 관계를 나타내는 엔티티 (다대다 관계)

필드

id: 고유 식별자

user: 해당 관계에 속한 사용자

schedule: 해당 관계에 속한 스케줄


 Timestamed
 
설명: 각 엔티티에 생성 및 수정 시간을 자동으로 기록하기 위한 상위 클래스

필드

createDate: 엔티티가 생성된 시간

modifiedDate: 엔티티가 마지막으로 수정된 시간

