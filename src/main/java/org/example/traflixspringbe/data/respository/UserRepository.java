package org.example.traflixspringbe.data.respository;

import org.example.traflixspringbe.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    // Find By
    UserEntity findFirstById(String id);
    UserEntity findFirstByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
    UserEntity findFirstByEmailAndPassword(String email, String password);


    // Exist By
    boolean existsByEmail(String email);
}