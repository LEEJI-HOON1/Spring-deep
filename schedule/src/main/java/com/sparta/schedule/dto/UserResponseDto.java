package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter

public class UserResponseDto {

    private Long id;
    private String username;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;


    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();

    }

    public UserResponseDto(Long id, String username,  String email, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}


