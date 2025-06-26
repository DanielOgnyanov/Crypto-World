import { useState } from 'react';
import './SellCrypto.css';
import { sellCrypto } from '../../Services/UserWalletService'; 

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

  
  const isValidSellValue = (val) => {
    
    return /^\d*\.?\d+$/.test(val) && parseFloat(val) > 0;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!isValidSellValue(sellValue) || !username || !cryptoAsset) {
      alert('Please fill in all fields with valid values.');
      return;
    }

    try {
      const value = parseFloat(sellValue);

      const result = await sellCrypto({
        usernameConfirm: username,
        sellValue: value,
        crypto: cryptoAsset
      });

      alert(`Sold successfully.`);
      setSellValue('');
      setUsername('');
      setCryptoAsset('');
    } catch (error) {
      alert('Failed to sell crypto: ' + error.message);
    }
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
        placeholder="Sell Value (e.g., 0.003)"
        type="text" 
        value={sellValue}
        onChange={(e) => {
          
          const val = e.target.value;
          if (val === '' || /^\d*\.?\d*$/.test(val)) {
            setSellValue(val);
          }
        }}
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
