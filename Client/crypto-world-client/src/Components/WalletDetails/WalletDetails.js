import './WalletDetails.css';

const WalletDetails = () => {
  return (
    <div className="wallet-details-container">
      <h2 className="wallet-title">Wallet Overview</h2>

      <div className="wallet-info-grid">
        <div className="wallet-info-item">
          <span className="label">Portfolio Created:</span>
          <span className="value">Jan 15, 2024</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Credit Card Name:</span>
          <span className="value">Visa Classic</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Last Sell:</span>
          <span className="value">BTC - $45,000</span>
        </div>

        <div className="wallet-info-item">
          <span className="label">Last Buy:</span>
          <span className="value">ETH - $3,000</span>
        </div>
      </div>
    </div>
  );
};

export default WalletDetails;
