package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.LogDeposit;
import com.example.cryptoworld.models.entities.LogSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogSellRepository extends JpaRepository<LogSell, Long> {
}
