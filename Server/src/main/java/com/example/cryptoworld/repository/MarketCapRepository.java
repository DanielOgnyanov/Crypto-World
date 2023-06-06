package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.AllMarketCap4HourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface MarketCapRepository extends JpaRepository<AllMarketCap4HourEntity, Long> {
    @Query("SELECT a.newMarketCap FROM AllMarketCap4HourEntity a")
    BigDecimal findNewMarketCap();

    @Query("SELECT b.oldMarketCap FROM AllMarketCap4HourEntity b")
    BigDecimal findOldMarketCap();


}
