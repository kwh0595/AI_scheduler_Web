package com.capstone.timeflow.controller;

import com.capstone.timeflow.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team/delete")
public class TeamDeleteController {

    @Autowired
    private TeamService teamService;

    @DeleteMapping("/{teamId}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
        System.out.println("delete" + teamId);
        return ResponseEntity.ok().build();
    }
}