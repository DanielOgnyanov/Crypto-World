import { useState } from 'react';
import './SellCrypto.css';

const SellCrypto = () => {
  const [sellValue, setSellValue] = useState('');
  const [username, setUsername] = useState('');
  const [cryptoAsset, setCryptoAsset] = useState('');

  const cryptoEnum = [
    { name: 'Bitcoin' },
    { name: 'Ethereum' },
    { name: 'Binance' },
    { name: 'Cardano' },
    { name: 'Tether' },
    { name: 'SOL' },
    { name: 'Ripple' },
    { name: 'Dotcoin' },
    { name: 'DogeCoin' },
    { name: 'USDC' }
  ];

  const handleSubmit = (e) => {
    e.preventDefault();

    const value = parseFloat(sellValue);

    if (isNaN(value)) {
      alert('Please enter a valid sell amount.');
      return;
    }

    if (value <= 0) {
      alert('Sell amount cannot be negative.');
      return;
    }

    if (!username || !cryptoAsset) {
      alert('Please fill in all fields.');
      return;
    }

    console.log('Selling:', {
      username,
      sellValue: value,
      cryptoAsset
    });

    
    setSellValue('');
    setUsername('');
    setCryptoAsset('');
  };

  return (
    <form id="form-sell-crypto" className="form-container" onSubmit={handleSubmit}>
      <p id="p-sell-crypto">Sell Crypto Asset</p>

      <label htmlFor="username-confirm" id="sell-crypto-label">Username Confirm</label>
      <input
        name="username-confirm"
        id="username-confirm"
        placeholder="Username Confirm"
        type="text"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />

      <label htmlFor="sell-value" id="sell-crypto-label">Sell Amount</label>
      <input
        name="sell-value"
        id="sell-value"
        placeholder="Sell Value"
        type="number"
        value={sellValue}
        onChange={(e) => setSellValue(e.target.value)}
        min="0"
      />

      <label htmlFor="crypto-asset" id="sell-crypto-label">Crypto Asset</label>
      <select
        id="crypto-asset"
        value={cryptoAsset}
        onChange={(e) => setCryptoAsset(e.target.value)}
      >
        <option value="">Select asset</option>
        {cryptoEnum.map((asset, index) => (
          <option key={index} value={asset.name}>
            {asset.name}
          </option>
        ))}
      </select>

      <button type="submit" id="button-sell-crypto">Sell Crypto</button>
    </form>
  );
};

export default SellCrypto;
