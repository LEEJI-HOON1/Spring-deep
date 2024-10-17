package com.sparta.schedule.service;

import com.sparta.schedule.dto.UserRequestDto;
import com.sparta.schedule.dto.UserResponseDto;
import com.sparta.schedule.entity.User;
import com.sparta.schedule.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // 유저 등록
    public UserResponseDto createUser(UserRequestDto requestDto){

        // RequestDto - > Entity
        User user = new User(requestDto);

        // DB 저장
        User saveUser = userRepository.save(user);

        // Entity -> ResponseDto
        UserResponseDto userResponseDto = new UserResponseDto(user);

        return userResponseDto;
    }

    // 유저 조회
    public List<UserResponseDto> getUser() {
        // DB 조회
        return userRepository.findAll().stream().map(UserResponseDto::new).toList();

    }

    @Transactional
    // 유저 수정
    public Long updateUser(Long id, UserRequestDto requestDto){
        // 해당 유저가 DB에 존재하는지 확인
        User user = findUser(id);
        //유저 내용 수정
        user.update(requestDto);

        return id;
    }

    public Long deleteUser(Long id){
        //해당 유저가 DB에 존재하는지 확인
        User user = findUser(id);

        // 유저 삭제
        userRepository.delete(user);

        return id;
    }

    private User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 유저는 존재하지 않습니다.")
        );
    }
}
