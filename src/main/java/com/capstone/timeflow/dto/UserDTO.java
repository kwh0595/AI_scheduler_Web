package com.capstone.timeflow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 가지는 생성자
public class UserDTO {
    private Long userId;
    private String userName;
    private String userMail;
    private String userPassword; //비밀번호 사용 시 해싱처리 필요.
    private LocalDate userBirth;
    private String userSex;
    private Integer userAge;
    private LocalDateTime userJoinDate;
}
