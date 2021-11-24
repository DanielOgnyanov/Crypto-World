package com.example.cryptoworld.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "wallet")
public class wallet extends BaseEntity{

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


    public wallet() {
    }

    @ManyToOne
    @JoinColumn(name = "owner_name", referencedColumnName = "full_name")
    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    @Column(name = "bitcoin")
    public double getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(double bitcoin) {
        this.bitcoin = bitcoin;
    }
    @Column(name = "ethereum")
    public double getEthereum() {
        return ethereum;
    }

    public void setEthereum(double ethereum) {
        this.ethereum = ethereum;
    }

    @Column(name = "binance")
    public double getBinance() {
        return binance;
    }

    public void setBinance(double binance) {
        this.binance = binance;
    }

    @Column(name = "cardano")
    public double getCardano() {
        return cardano;
    }

    public void setCardano(double cardano) {
        this.cardano = cardano;
    }

    @Column(name = "tether")
    public double getTether() {
        return tether;
    }

    public void setTether(double tether) {
        this.tether = tether;
    }

    @Column(name = "solana")
    public double getSolana() {
        return solana;
    }

    public void setSolana(double solana) {
        this.solana = solana;
    }

    @Column(name = "xrp")
    public double getXrp() {
        return xrp;
    }

    public void setXrp(double xrp) {
        this.xrp = xrp;
    }

    @Column(name = "polkadot")
    public double getPolkadot() {
        return polkadot;
    }

    public void setPolkadot(double polkadot) {
        this.polkadot = polkadot;
    }

    @Column(name = "dogecoin")
    public double getDogecoin() {
        return dogecoin;
    }

    public void setDogecoin(double dogecoin) {
        this.dogecoin = dogecoin;
    }

    @Column(name = "usdcoin")
    public double getUsdcoin() {
        return usdcoin;
    }

    public void setUsdcoin(double usdcoin) {
        this.usdcoin = usdcoin;
    }
}
