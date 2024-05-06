package com.capstone.timeflow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "SCHEDULE")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private Long sid;

    @Column(name = "sname", nullable = false, length = 100)
    private String sname;

    @Column(name = "scontents", length = 255)
    private String scontents;

    @Column(name = "schedule_time", nullable = false)
    private LocalDateTime scheduleTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "sprocess", length = 50)
    private String sprocess;  // 일정 진행 상태


    // 일정의 등록자 정보가 필요하면 User 객체와의 관계를 추가할 수 있습니다.
    // @ManyToOne 등의 관계 설정이 필요할 수 있습니다.
}
