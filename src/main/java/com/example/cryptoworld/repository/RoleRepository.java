package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.enums.EnumRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByRole(EnumRole role);
}
