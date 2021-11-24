package com.example.cryptoworld.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "wallet")
public class WalletEntity extends BaseEntity{

    private UserEntity owner;
    private double bitcoin;
    private double ethereum;
    private double binance;
    private double cardano;
    private double tether;
    private double solana;
    private double xrp;
    private double polkadot;
    private double dogecoin;
    private double usdcoin;


    public WalletEntity() {
    }

    @ManyToOne
    @JoinColumn(name = "owner_name", referencedColumnName = "full_name")
    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    @Column(name = "bitcoin", columnDefinition = "Decimal(10,2) default '0'")
    public double getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(double bitcoin) {
        this.bitcoin = bitcoin;
    }
    @Column(name = "ethereum",  columnDefinition = "Decimal(10,2) default '0'")
    public double getEthereum() {
        return ethereum;
    }

    public void setEthereum(double ethereum) {
        this.ethereum = ethereum;
    }

    @Column(name = "binance", columnDefinition = "Decimal(10,2) default '0'")
    public double getBinance() {
        return binance;
    }

    public void setBinance(double binance) {
        this.binance = binance;
    }

    @Column(name = "cardano", columnDefinition = "Decimal(10,2) default '0'")
    public double getCardano() {
        return cardano;
    }

    public void setCardano(double cardano) {
        this.cardano = cardano;
    }

    @Column(name = "tether", columnDefinition = "Decimal(10,2) default '0'")
    public double getTether() {
        return tether;
    }

    public void setTether(double tether) {
        this.tether = tether;
    }

    @Column(name = "solana", columnDefinition = "Decimal(10,2) default '0'")
    public double getSolana() {
        return solana;
    }

    public void setSolana(double solana) {
        this.solana = solana;
    }

    @Column(name = "xrp", columnDefinition = "Decimal(10,2) default '0'")
    public double getXrp() {
        return xrp;
    }

    public void setXrp(double xrp) {
        this.xrp = xrp;
    }

    @Column(name = "polkadot", columnDefinition = "Decimal(10,2) default '0'")
    public double getPolkadot() {
        return polkadot;
    }

    public void setPolkadot(double polkadot) {
        this.polkadot = polkadot;
    }

    @Column(name = "dogecoin", columnDefinition = "Decimal(10,2) default '0'")
    public double getDogecoin() {
        return dogecoin;
    }

    public void setDogecoin(double dogecoin) {
        this.dogecoin = dogecoin;
    }

    @Column(name = "usdcoin", columnDefinition = "Decimal(10,2) default '0'")
    public double getUsdcoin() {
        return usdcoin;
    }

    public void setUsdcoin(double usdcoin) {
        this.usdcoin = usdcoin;
    }
}
