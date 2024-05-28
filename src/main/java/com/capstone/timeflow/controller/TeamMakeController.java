package com.capstone.timeflow.controller;

import com.capstone.timeflow.entity.UserEntity;
import com.capstone.timeflow.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamMakeController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/create")
    public ResponseEntity<String> createTeam(@RequestParam String name, @AuthenticationPrincipal UserEntity currentUser) {
        System.out.println(currentUser.getUserId());

        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        try {
            teamService.createTeam(name, currentUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("Team Created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create team");
        }
    }
}