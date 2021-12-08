package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.LogDeposit;
import com.example.cryptoworld.models.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDepositRepository extends JpaRepository<LogDeposit, Long> {


    @Query("select d from LogDeposit as d order by d.cryptoValue desc ")
    List<LogDeposit> findAllDepositOrderedDesc();


    @Query("select da from LogDeposit as da order by da.cryptoValue asc ")
    List<LogDeposit> lowestDeposit();
}
