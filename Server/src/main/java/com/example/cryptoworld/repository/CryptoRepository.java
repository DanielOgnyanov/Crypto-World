package com.example.cryptoworld.repository;

import com.example.cryptoworld.models.entities.CryptoCurrenciesEntity;
import com.example.cryptoworld.models.view.CryptoTableViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CryptoRepository extends JpaRepository<CryptoCurrenciesEntity, Long> {

    Optional<CryptoCurrenciesEntity> findByName(String cryptoName);

    @Query("select c from CryptoCurrenciesEntity as c where c.assetStringId like :assetId")
    CryptoCurrenciesEntity getCryptoByAssetStringId(String assetId);

    @Query("SELECT p FROM CryptoCurrenciesEntity p")
    List<CryptoCurrenciesEntity> getPopularCrypto();


    @Query("Select Sum(a.price) from CryptoCurrenciesEntity as a")
    BigDecimal cryptoMarketCap4Hour();


    @Query("Select b.price from CryptoCurrenciesEntity as b where b.name like :name")
    Double getCurrentPrice (String name);

    @Query("Select d from CryptoCurrenciesEntity as d")
    List<CryptoCurrenciesEntity> getAllCryptoPrices();
}
