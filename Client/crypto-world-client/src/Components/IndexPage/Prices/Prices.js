import { useState, useEffect } from 'react';
import { getMarketCap24Hour, getPercentageDifferenceInMarketCap, getAllCryptoPrices, getListOfCryptoPrices } from '../../../Services/CryptoService';
import './Prices.css';
import { Line } from 'react-chartjs-2';

const Prices = () => {
  const [data, setData] = useState('');
  const [marketCapDifference, setMarketCapDifference] = useState('');
  const [crypto, setCrypto] = useState([]);
  const [updatedLabels, setUpdatedLabels] = useState([]);
  const [updatedData, setUpdatedData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const fetchResult = await getMarketCap24Hour();
        setData(fetchResult);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };
    fetchData();
    const interval = setInterval(fetchData, 20000);
    return () => clearInterval(interval);
  }, []);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const fetchResult = await getPercentageDifferenceInMarketCap();
        setMarketCapDifference(fetchResult);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };
    fetchData();
    const interval = setInterval(fetchData, 20000);
    return () => clearInterval(interval);
  }, []);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const fetchResult = await getAllCryptoPrices();
        setCrypto(fetchResult);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };
    fetchData();
    const interval = setInterval(fetchData, 20000);
    return () => clearInterval(interval);
  }, []);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const fetchResult = await getListOfCryptoPrices();

        const labels = fetchResult.map((crypto) =>
          crypto[0]?.recordedAt?.map((time) => new Date(time).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })) || []
        );

        const data = fetchResult.map((crypto) => crypto[0]?.price || []);

        setUpdatedLabels(labels);
        setUpdatedData(data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
    const interval = setInterval(fetchData, 50000);
    return () => clearInterval(interval);
  }, []);

  const formatPrice = (price) => {
    return parseFloat(price).toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 8 });
  };

  return (
    <>
      <div className="market-info">
        <span>
          The cryptocurrency market cap today is{' '}
          <strong className="market-cap-value">${formatPrice(data)}</strong>, a
          <br />
          <strong className={`percentage-change ${marketCapDifference >= 0 ? 'positive' : 'negative'}`}>
            {marketCapDifference}%
          </strong>{' '}
          change from 24 hours ago.
        </span>
      </div>

      <div className="table-container">
        <table className="crypto-table">
          <thead>
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Price (USD)</th>
              <th>Price Chart</th>
            </tr>
          </thead>
          <tbody>
            {crypto.map((item, index) => (
              <tr key={item.id}>
                <td>{index + 1}</td>
                <td className="name-cell">
                  <img src={item.logoImage} alt={item.name} className="crypto-logo" />
                  <span>{item.name}</span>
                </td>
                <td>${formatPrice(item.price)}</td>
                <td className="chart-cell">
                  <Line
                    data={{
                      labels: updatedLabels[index] || [],
                      datasets: [
                        {
                          data: updatedData[index] || [],
                          borderColor: '#4caf50',
                          fill: false,
                          tension: 0.3,
                          pointRadius: 0,
                        },
                      ],
                    }}
                    options={{
                      responsive: true,
                      maintainAspectRatio: false,
                      plugins: {
                        legend: { display: false },
                      },
                      scales: {
                        x: { display: false },
                        y: { display: false },
                      },
                    }}
                    height={50}
                    width={150}
                  />
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default Prices;
