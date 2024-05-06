package com.capstone.timeflow.controller;

import com.capstone.timeflow.dto.ScheduleDTO;
import com.capstone.timeflow.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedule")
    public String addSchedule(@ModelAttribute ScheduleDTO scheduleDTO) {
        scheduleService.createSchedule(scheduleDTO);
        return "redirect:/schedules";
    }

    @PutMapping("/schedule/{id}")
    public String updateSchedule(@PathVariable Long id, @RequestParam String process) {
        scheduleService.updateSchedule(id, process);
        return "redirect:/schedules";
    }

    @DeleteMapping("/schedule/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return "redirect:/schedules";
    }
}
