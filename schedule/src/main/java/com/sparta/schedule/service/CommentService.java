package com.sparta.schedule.service;

import com.sparta.schedule.dto.CommentRequestDto;
import com.sparta.schedule.dto.CommentResponseDto;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
        // 댓글 등록
    public CommentResponseDto createComment(CommentRequestDto requestDto){

        // RequestDto - > Entity
        Comment comment = new Comment(requestDto);

        // DB 저장
        Comment saveComment = commentRepository.save(comment);

        // Entity -> ResponseDto
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);

        return commentResponseDto;
    }

        // 댓글 조회
    public List<CommentResponseDto> getComment() {
        // DB 조회
        return commentRepository.findAll().stream().map(CommentResponseDto::new).toList();

    }

    @Transactional
        // 댓글 수정
    public Long updateComment(Long id, CommentRequestDto requestDto){
        // 해당 댓글이 DB에 존재하는지 확인
        Comment comment = findComment(id);
        //댓글 내용 수정
        comment.update(requestDto);

        return id;
    }

    public Long deleteComment(Long id){
        //해당 댓글이 DB에 존재하는지 확인
        Comment comment = findComment(id);

        // 댓글 삭제
        commentRepository.delete(comment);

        return id;
    }

    private Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 댓글은 존재하지 않습니다.")
        );
    }
}
