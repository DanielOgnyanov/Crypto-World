import React, { useEffect, useState } from 'react';
import './WalletDetails.css';
import { getUserWallet } from '../../Services/UserWalletService'; // adjust path if needed

const WalletDetails = () => {
  const [wallet, setWallet] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    async function fetchWallet() {
      try {
        const data = await getUserWallet();
        setWallet(data);
      } catch (err) {
        setError(err.toString());
      } finally {
        setLoading(false);
      }
    }

    fetchWallet();
  }, []);

  if (loading) return <div>Loading wallet data...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <div className="wallet-details-container">
      <h2 className="wallet-title">Wallet Overview</h2>

      <div className="wallet-info-grid">
        <div className="wallet-info-item">
          <span className="label">Owner:</span>
          <span className="value">{wallet.owner.fullName} ({wallet.owner.username})</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Wallet Address:</span>
          <span className="value">{wallet.owner.walletAddress}</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Bitcoin (BTC):</span>
          <span className="value">{wallet.bitcoin}</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Ethereum (ETH):</span>
          <span className="value">{wallet.ethereum}</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Binance Coin (BNB):</span>
          <span className="value">{wallet.binance}</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Cardano (ADA):</span>
          <span className="value">{wallet.cardano}</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Tether (USDT):</span>
          <span className="value">{wallet.tether}</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Solana (SOL):</span>
          <span className="value">{wallet.solana}</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">XRP:</span>
          <span className="value">{wallet.xrp}</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Polkadot (DOT):</span>
          <span className="value">{wallet.polkadot}</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Dogecoin (DOGE):</span>
          <span className="value">{wallet.dogecoin}</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">USD Coin (USDC):</span>
          <span className="value">{wallet.usdcoin}</span>
        </div>
      </div>
    </div>
  );
};

export default WalletDetails;
