package com.capstone.timeflow.entity;

import com.capstone.timeflow.dto.UserDTO;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Getter
@Setter
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private Long userId;

    @Column(name="userName",nullable = false,length=35)
    private String userName;

    @Column(name="userMail",length=50)
    private String userMail;     //사용자 아이디

    @Column(name="userPassword", nullable = false,length =100)
    private String userPassword;    //사용자 비밀번호 해싱 과정 필요

    @Column(name="userBirth",nullable = false)
    private LocalDate userBirth;

    @Column(name="userSex",nullable = false, length=25)
    private String userSex;

    @Column(name="userAge",columnDefinition = "int default 20")
    private Integer userAge;

    @Column(name = "userJoinDate")
    private LocalDateTime userJoinDate = LocalDateTime.now(); // 현재 시간으로 초기화
    public static UserEntity toUserEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserMail(userDTO.getUserMail());
        userEntity.setUserPassword(userDTO.getUserPassword());
        //userEntity.setUserAge(userDTO.getUserAge());
        userEntity.setUserBirth(userDTO.getUserBirth());
        userEntity.setUserJoinDate(userDTO.getUserJoinDate());
        userEntity.setUserSex(userDTO.getUserSex());
        // 나이 계산
        LocalDate today = LocalDate.now(); // 현재 날짜
        LocalDate birthDate = userDTO.getUserBirth(); // 사용자의 생년월일
        if (birthDate != null) {
            int age = Period.between(birthDate, today).getYears();
            userEntity.setUserAge(age);
        }
        return userEntity;
    }
}

