package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ScheduleResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();

    }

    public ScheduleResponseDto(Long id, String username, String title, String content, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
