package com.capstone.timeflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FindIdController {
    // 아이디 찾기 페이지 요청
    @GetMapping("/find-id")
    public String findIdForm() {
        return "findId"; //
    }
    @PostMapping("/find-id")
    public String findId(@RequestParam("name") String name,
                         @RequestParam("phone") String phone
    ) {


        return "login";
    }
}