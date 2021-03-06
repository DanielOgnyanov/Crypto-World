package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.LogSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogSellRepository extends JpaRepository<LogSell, Long> {

    @Query("select s from LogSell as s order by s.cryptoToSell desc ")
    List<LogSell> getAllLogSellOrderDesc();

    @Query("select se from LogSell as se order by se.cryptoToSell asc ")
    List<LogSell> orderAsc();
}
