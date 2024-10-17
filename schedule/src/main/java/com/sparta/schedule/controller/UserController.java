package com.sparta.schedule.controller;

import com.sparta.schedule.dto.UserRequestDto;
import com.sparta.schedule.dto.UserResponseDto;
import com.sparta.schedule.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //댓글 등록

    @PostMapping("/user")
    public UserResponseDto createuser (@RequestBody UserRequestDto requestDto){
        return userService.createUser(requestDto);
    }

    //댓글 조회

    @GetMapping("/user")
    public List<UserResponseDto> getUser() {
        return userService.getUser();
    }

    //댓글 수정

    @PutMapping("/user/{id}")
    public Long updateUser(@PathVariable(value = "id") Long id, @RequestBody UserRequestDto requestDto){
        return userService.updateUser(id, requestDto);
    }

    //댓글 삭제

    @DeleteMapping("/user/{id}")
    public Long deleteUser(@PathVariable(value = "id") Long id){
        return userService.deleteUser(id);
    }
}
