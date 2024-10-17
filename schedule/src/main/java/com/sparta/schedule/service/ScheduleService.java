package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

        // 스케줄 등록
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        // RequestDto - > Entity
        Schedule schedule = new Schedule(requestDto);


        // DB 저장
        Schedule saveSchedule = scheduleRepository.save(schedule);

        // Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    public List<ScheduleResponseDto> getSchedule() {
        // DB 조회
        return  scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).toList();

    }
    @Transactional
    public Long updateSchedule(Long id, ScheduleRequestDto requestDto){
        // 해당 스케줄이 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);
        //스케줄 내용 수정
        schedule.update(requestDto);

        return id;

    }

    @Transactional
    public Long deleteSchedule(Long id) {
        //해당 스케줄이 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);

        //스케줄 삭제
        scheduleRepository.delete(schedule);

        return id;
    }

    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 스케줄은  존재하지 않습니다.")
        );
    }

    //일정 페이징 조회 메서드
    public Page<Schedule> getSchedules(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return scheduleRepository.findAllByOrderByModifiedDateDesc(pageable);


    }

}

