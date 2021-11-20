package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.UserEntity;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<UserEntity> getByUsername(String username);
}
