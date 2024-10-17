package com.sparta.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentRequestDto {
    @NotBlank
    private String username;
    @NotBlank
    private String content;
}
