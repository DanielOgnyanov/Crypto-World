package com.example.cryptoworld.repository;


import com.example.cryptoworld.models.entities.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {

    CreditCardEntity findByOwner(String owner);

    @Query("select c from CreditCardEntity  as c where c.owner.username like :username")
    List<CreditCardEntity> getCardByOwner(String username);


    @Query("select ca from CreditCardEntity as ca order by ca.balance desc ")
    List<CreditCardEntity> getAllCardOrderedByBalance();
}
