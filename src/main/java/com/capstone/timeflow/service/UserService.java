package com.capstone.timeflow.service;

import com.capstone.timeflow.dto.UserDTO;
import com.capstone.timeflow.entity.UserEntity;
import com.capstone.timeflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
   private final UserRepository userRepository;
    public void save(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        userRepository.save(userEntity);
    }
}
