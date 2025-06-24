import './HomePage.css';
import { useEffect, useState } from 'react';
import * as cryptoService from '../../Services/CryptoService';
import Chart from '../Chart/Chart';
import WalletDetails from '../WalletDetails/WalletDetails';
import UserDetails from './UserDetails/UserDetails';

const HomePage = () => {
  const [cryptoItem, setCryptoItem] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchPrices = async () => {
      try {
        const data = await cryptoService.getAllCryptoPrices();
        setCryptoItem(data);
      } catch (error) {
        console.error('Failed to fetch crypto prices:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchPrices();
  }, []);

  return (
    <div className="home" id="home">
      <div className="user-info-welcome">
        <UserDetails />
      </div>

      <div className="chart">
        <Chart />
      </div>

      <div className="wallet-details">
        <WalletDetails />
      </div>

      <div className="table-container">
        <h2 className="table-title">Market Overview</h2>
        {loading ? (
          <p>Loading market data...</p>
        ) : (
          <table className="homepage-table">
            <thead>
              <tr>
                <th>#</th>
                <th>Crypto Name</th>
                <th>Current Price ($)</th>
                <th>% Change</th>
              </tr>
            </thead>
            <tbody>
              {cryptoItem.map((item, index) => {
                const percentageChange =
                  item.oldPriceTrack && item.price
                    ? (((item.price - item.oldPriceTrack) / item.oldPriceTrack) * 100).toFixed(2)
                    : '0.00';

                return (
                  <tr key={item.id}>
                    <td>{index + 1}</td>
                    <td>
                      <img
                        src={item.logoImage}
                        alt={item.name}
                        style={{ width: '20px', verticalAlign: 'middle', marginRight: '8px' }}
                      />
                      {item.name}
                    </td>
                    <td>${item.price.toLocaleString()}</td>
                    <td style={{ color: percentageChange >= 0 ? 'green' : 'red' }}>
                      {percentageChange}%
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
};

export default HomePage;
