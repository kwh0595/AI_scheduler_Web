package com.capstone.timeflow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 가지는 생성자
public class ScheduleDTO {

    private Long sid;
    private String sname;
    private String scontents;
    private LocalDateTime scheduleTime;
    private LocalDateTime endTime;
    private String sprocess;


    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScontents() {
        return scontents;
    }

    public void setScontents(String scontents) {
        this.scontents = scontents;
    }

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setendTime(LocalDateTime endtime) {
        this.endTime = endTime;
    }


    public String getSprocess() {
        return sprocess;
    }

    public void setSprocess(String sprocess) {
        this.sprocess = sprocess;
    }





}
