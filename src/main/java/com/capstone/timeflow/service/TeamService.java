package com.capstone.timeflow.service;

import com.capstone.timeflow.entity.RoleEntity;
import com.capstone.timeflow.entity.TeamEntity;
import com.capstone.timeflow.entity.UserEntity;
import com.capstone.timeflow.initialdata.enumRole;
import com.capstone.timeflow.repository.RoleRepository;
import com.capstone.timeflow.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JoinCodeService joinCodeService;

    // 팀 생성 메소드
    public TeamEntity createTeam(String name, UserEntity creator) {
        TeamEntity team = new TeamEntity();
        team.setTeamName(name);
        team.setJoinCode(joinCodeService.joinCodeGenerate((int)(Math.random()*10)));

        // 팀 저장
        team = teamRepository.save(team);

        // 사용자를 팀의 리더로 설정
        // 팀 생성자를 팀의 리더로 설정
        RoleEntity roleEntity = new RoleEntity(creator, team, enumRole.LEADER);
        roleRepository.save(roleEntity);

        return team;
    }

    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
    }

    private String generateInvitationCode() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5 + new Random().nextInt(6); // 5~10자리

        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}