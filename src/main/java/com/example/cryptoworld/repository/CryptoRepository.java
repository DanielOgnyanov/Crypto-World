package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.enums.EnumCryptoTop10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoRepository extends JpaRepository<CryptoCurrenciesEntity, Long> {

    Optional<CryptoCurrenciesEntity> findByName(EnumCryptoTop10 cryptoName);

    @Query("select c from CryptoCurrenciesEntity as c where c.assetStringId like :assetId")
    CryptoCurrenciesEntity getCryptoByAssetStringId(String assetId);
}
