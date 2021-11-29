package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.entities.WalletEntity;
import com.example.cryptoworld.models.view.WalletViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

    boolean existsByUsername(String username);

    WalletEntity findByUsername (String username);

    @Query("select w from WalletEntity as w where w.username like :username")
    List<WalletEntity> findByUsernameMethod(String username);
}
