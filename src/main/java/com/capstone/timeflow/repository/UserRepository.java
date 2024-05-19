package com.capstone.timeflow.repository;

import com.capstone.timeflow.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUserMail(String userMail);
}
