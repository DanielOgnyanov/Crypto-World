package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);


    Optional<UserEntity> findByUsername(String username);


    @Query("select u from UserEntity as u order by u.username")
    List<UserEntity> findAllOrderedByUsername();

}
