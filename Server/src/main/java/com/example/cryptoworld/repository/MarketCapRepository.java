package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.AllMarketCap4HourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketCapRepository extends JpaRepository<AllMarketCap4HourEntity, Long> {
}
