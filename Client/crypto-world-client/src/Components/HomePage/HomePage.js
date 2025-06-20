import './HomePage.css';
import * as cryptoService from '../../Services/CryptoService';
import Chart from '../Chart/Chart';
import WalletDetails from '../WalletDetails/WalletDetails';
import UserDetails from './UserDetails/UserDetails';

const HomePage = () => {
  const cryptoPrices = cryptoService.getCryptoPrice;

  const cryptoItem = [
    { id: 1, name: 'Bitcoin', price: 45000 },
    { id: 2, name: 'Ethereum', price: 3000 }
  ];

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
        <table className="homepage-table">
          <thead>
            <tr>
              <th>#</th>
              <th>Crypto Name</th>
              <th>Current Price ($)</th>
            </tr>
          </thead>
          <tbody>
            {cryptoItem.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>${item.price.toLocaleString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default HomePage;
