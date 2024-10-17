package com.sparta.schedule.controller;

import com.sparta.schedule.dto.CommentRequestDto;
import com.sparta.schedule.dto.CommentResponseDto;
import com.sparta.schedule.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private  final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    //댓글 등록

    @PostMapping("/comment")
    public CommentResponseDto createComment (@RequestBody CommentRequestDto requestDto){
        return commentService.createComment(requestDto);
    }

    //댓글 조회

    @GetMapping("/comment")
    public List<CommentResponseDto> getComment() {
        return commentService.getComment();
    }

    //댓글 수정

    @PutMapping("/comment/{id}")
    public Long updateComment(@PathVariable(value = "id") Long id, @RequestBody CommentRequestDto requestDto){
        return commentService.updateComment(id, requestDto);
    }

    //댓글 삭제

    @DeleteMapping("/comment/{id}")
    public Long deleteComment(@PathVariable(value = "id") Long id){
        return commentService.deleteComment(id);
    }
}
