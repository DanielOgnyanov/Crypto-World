package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.PriceHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceHistoryRepository extends JpaRepository<PriceHistoryEntity, Long> {

    @Query("SELECT p FROM PriceHistoryEntity p")
    List<Object[]> groupedCryptoByName();

    PriceHistoryEntity findByName(String name);
}
