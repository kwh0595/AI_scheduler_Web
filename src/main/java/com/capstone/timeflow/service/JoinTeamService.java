package com.capstone.timeflow.service;

import com.capstone.timeflow.entity.RoleEntity;
import com.capstone.timeflow.entity.TeamEntity;
import com.capstone.timeflow.entity.UserEntity;
import com.capstone.timeflow.initialdata.enumRole;
import com.capstone.timeflow.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JoinTeamService {

    @Autowired
    private RoleRepository roleRepository;

    public boolean addUserToTeam(Optional<TeamEntity> team, UserEntity user) {
        if (team.isEmpty()) {
            // 팀이 존재하지 않는 경우
            return false;
        }

        // 이미 팀에 가입되어 있는지 확인
        boolean isAlreadyMember = roleRepository.existsByTeamIdAndUserId(team.get(), user);
        if (isAlreadyMember) {
            // 이미 멤버인 경우 추가하지 않고 true 반환
            return true;
        }

        // 새로운 Role 객체를 생성하여 사용자를 팀에 추가
        RoleEntity newRole = new RoleEntity();
        newRole.setUserId(user); // UserEntity 객체를 설정
        newRole.setTeamId(team.get()); // TeamEntity 객체를 설정
        newRole.setRole(enumRole.MEMBER); // 기본적으로 'Member' 역할을 할당
        roleRepository.save(newRole);

        return true;
    }
}