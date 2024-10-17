package com.sparta.schedule.controller;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.service.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //일정 등록
    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule (@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    //  페이징된 일정 목록 조회
    @GetMapping("/schedules")
    public Page<Schedule> getPagedSchedules(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return scheduleService.getSchedules(page, size);
    }

    // 일정 조회
    @GetMapping("/schedule")
    public List<ScheduleResponseDto> getSchedule() {
        return scheduleService.getSchedule();
    }

    //일정 수정
    @PutMapping("/schedule/{id}")
    public Long updateSchedule(@PathVariable(value = "id") Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, requestDto);
    }


    //일정 삭제
    @DeleteMapping("/schedule/{id}")
    public Long deleteSchedule(@PathVariable(value = "id") Long id) {
       return scheduleService.deleteSchedule(id);

    }

}

