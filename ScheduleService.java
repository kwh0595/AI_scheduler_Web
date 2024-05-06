package com.capstone.timeflow.service;

import com.capstone.timeflow.dto.ScheduleDTO;
import com.capstone.timeflow.entity.ScheduleEntity;
import com.capstone.timeflow.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleEntity createSchedule(ScheduleDTO scheduleDTO) {
        ScheduleEntity schedule = new ScheduleEntity();
        schedule.setScontents(scheduleDTO.getScontents());
        schedule.setScheduleTime(scheduleDTO.getScheduleTime());
        schedule.setEndTime(scheduleDTO.getEndTime());
        schedule.setSprocess(scheduleDTO.getSprocess());

        return scheduleRepository.save(schedule);
    }

    @Transactional
    public boolean updateSchedule(Long id, String process) {
        ScheduleEntity schedule = scheduleRepository.findById(id).orElse(null);
        if (schedule != null) {
            schedule.setSprocess(process);
            scheduleRepository.save(schedule);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deleteSchedule(Long id) {
        if (scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
