package com.capstone.timeflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class FindIdController {
    // 아이디 찾기 페이지 요청
    @GetMapping("/user/findId")
    public String findIdForm() {
        return "findId"; //
    }

}