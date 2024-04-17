package com.capstone.timeflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FindPasswordController {
    // 비밀번호 찾기 페이지 요청
    @GetMapping("user/findPassword")
    public String findPasswordForm() {
        return "findPassword";
    }
    @PostMapping("/findPassword")
    public String findPassword(@RequestParam("Id") String userId,
                               @RequestParam("phone") String phone
    ) {
        System.out.println("MemberController.signup");
        System.out.println("userId = " + userId + ", phone = " + phone);
        return "login";
    }
}