package com.capstone.timeflow.controller;

import com.capstone.timeflow.dto.UserDTO;
import com.capstone.timeflow.entity.UserEntity;
import com.capstone.timeflow.service.UserService;
import com.capstone.timeflow.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    //회원가입 페이지 출력 요청
    @GetMapping("/user/signup")
    public String signupForm(){
      return "signUp";
    }
    @PostMapping("/user/signup")
    public String signup(@ModelAttribute UserDTO userDTO){
        System.out.println("UserController.signup");
        userService.save(userDTO);
        return "login";
    }
    @GetMapping("/login/info")
    public String userInfo(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
        System.out.println(userId);
        UserEntity loginUser = userService.getLoginUserById(userId);

        if(loginUser == null) {
            return "login";
        }
        model.addAttribute("user", loginUser);
        return "info";
    }

}
