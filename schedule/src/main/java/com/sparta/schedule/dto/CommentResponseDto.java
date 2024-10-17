package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class CommentResponseDto {

    private Long id;
    private String username;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.username = comment.getUsername();
        this.content = comment.getContent();

    }

    public CommentResponseDto(Long id, String username,  String content, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.content = content;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}


