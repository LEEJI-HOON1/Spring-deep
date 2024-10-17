package com.sparta.schedule.entity;

import com.sparta.schedule.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
@Entity
public class Comment extends Timestamed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;


    public Comment(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.content = requestDto.getContent();

    }

    public void update(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.content = requestDto.getContent();

    }
}
