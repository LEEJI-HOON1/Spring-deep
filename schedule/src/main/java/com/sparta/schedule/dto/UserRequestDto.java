package com.sparta.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserRequestDto {
    @NotBlank
    private String username;
    @NotBlank
    private String email;

}
