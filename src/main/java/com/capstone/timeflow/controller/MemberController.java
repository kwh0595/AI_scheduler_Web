package com.capstone.timeflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
    //회원가입 페이지 출력 요청
    @GetMapping("/member/signup")
    public String signupForm(){
      return "signUp";
    }
    @PostMapping("/member/signup")
    public String signup(@RequestParam("memberEmail") String memberEmail,
                         @RequestParam("memberName")String memberName,
                         @RequestParam("memberPassword") String memberPassword,
                         @RequestParam("memberPasswordCheck") String memberPasswordCheck,
                         @RequestParam("memberPhone1")String memberPhone1,
                         @RequestParam("memberPhone2")String memberPhone2,
                         @RequestParam("memberPhone3")String memberPhone3
                        ){
        System.out.println("MemberController.signup");
        System.out.println("memberEmail = "+memberEmail + ", memberName = "+memberName+", memberPassword = "+memberPassword+", passwordCheck = "+memberPasswordCheck+
                ", phoneNo = "+ memberPhone1+"-"+memberPhone2+"-"+memberPhone3);
        return "login";
    }
}
