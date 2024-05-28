package com.capstone.timeflow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 가지는 생성자
public class TeamDTO {
    private Long teamId;
    private String teamName;
    private LocalDateTime teamCreationDate;
    private String joinCode;
}
