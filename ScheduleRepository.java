package com.capstone.timeflow.repository;

import com.capstone.timeflow.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
    // 여기에 필요한 JPA 메소드를 추가할 수 있습니다.
}