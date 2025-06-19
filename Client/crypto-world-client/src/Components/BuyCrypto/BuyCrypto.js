import { useState } from 'react';
import './BuyCrypto.css';

const BuyCrypto = () => {
  const [deposit, setDeposit] = useState('');
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

    const value = parseFloat(deposit);

    if (isNaN(value)) {
      alert('Please enter a valid deposit value.');
      return;
    }

    if (value <= 0) {
      alert('Deposit cannot be negative.');
      return;
    }

    if (!username || !cryptoAsset) {
      alert('Please fill in all fields.');
      return;
    }

    console.log('Buying:', {
      username,
      deposit: value,
      cryptoAsset
    });

    
    setDeposit('');
    setUsername('');
    setCryptoAsset('');
  };

  return (
    <form id="form-buy-crypto" className="form-container" onSubmit={handleSubmit}>
      <p id="p-buy-crypto">Buy Crypto Asset</p>

      <label htmlFor="username-confirm" id="buy-crypto-label">Username Confirm</label>
      <input
        name="username-confirm"
        id="username-confirm"
        placeholder="Username Confirm"
        type="text"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />

      <label htmlFor="deposit" id="buy-crypto-label">Deposit</label>
      <input
        name="deposit"
        id="deposit"
        placeholder="Deposit"
        type="number"
        value={deposit}
        onChange={(e) => setDeposit(e.target.value)}
        min="0"
      />

      <label htmlFor="crypto-asset" id="buy-crypto-label">Crypto Asset</label>
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

      <button type="submit" id="button-buy-crypto">Buy Crypto</button>
    </form>
  );
};

export default BuyCrypto;
