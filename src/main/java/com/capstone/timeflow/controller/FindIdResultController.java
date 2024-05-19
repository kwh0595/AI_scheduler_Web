package com.capstone.timeflow.controller;

import com.capstone.timeflow.service.FindEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FindIdResultController {

    @Autowired
    private FindEmailService findEmailService;
    @PostMapping("/user/findId")
    public String findIdResult(@RequestParam("userName") String userName,
                               @RequestParam("userBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate userBirth,
                               Model model) {

        try {
            String userEmail = findEmailService.findEmailByNameAndBirthDate(userName, userBirth);
            model.addAttribute("findIdResult", userEmail);
            System.out.println(userEmail);
            return "findIdResult";
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("에러나요");
            return "findIdResult"; // 실제 서비스에서는 사용자에게 예외 메시지를 직접 반환하는 것보다 오류 코드나 메시지를 정의하는 것이 좋습니다.
        }
    }
}
