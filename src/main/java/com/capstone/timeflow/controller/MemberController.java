package com.capstone.timeflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    //회원가입 페이지 출력 요청
    @GetMapping("/member/signup")
    public String signupForm(){
      return "signUp";
    }
}
