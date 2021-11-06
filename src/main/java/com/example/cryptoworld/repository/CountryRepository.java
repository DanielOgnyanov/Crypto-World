package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.CountryEntity;
import com.example.cryptoworld.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
