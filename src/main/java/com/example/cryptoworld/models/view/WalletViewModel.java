package com.example.cryptoworld.models.view;

public class WalletViewModel {

    private String owner;
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


    public WalletViewModel() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(double bitcoin) {
        this.bitcoin = bitcoin;
    }

    public double getEthereum() {
        return ethereum;
    }

    public void setEthereum(double ethereum) {
        this.ethereum = ethereum;
    }

    public double getBinance() {
        return binance;
    }

    public void setBinance(double binance) {
        this.binance = binance;
    }

    public double getCardano() {
        return cardano;
    }

    public void setCardano(double cardano) {
        this.cardano = cardano;
    }

    public double getTether() {
        return tether;
    }

    public void setTether(double tether) {
        this.tether = tether;
    }

    public double getSolana() {
        return solana;
    }

    public void setSolana(double solana) {
        this.solana = solana;
    }

    public double getXrp() {
        return xrp;
    }

    public void setXrp(double xrp) {
        this.xrp = xrp;
    }

    public double getPolkadot() {
        return polkadot;
    }

    public void setPolkadot(double polkadot) {
        this.polkadot = polkadot;
    }

    public double getDogecoin() {
        return dogecoin;
    }

    public void setDogecoin(double dogecoin) {
        this.dogecoin = dogecoin;
    }

    public double getUsdcoin() {
        return usdcoin;
    }

    public void setUsdcoin(double usdcoin) {
        this.usdcoin = usdcoin;
    }
}
