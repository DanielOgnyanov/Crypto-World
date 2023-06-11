import { useState, useEffect, useRef } from 'react';
import Chart from 'chart.js/auto';
import { getMarketCap24Hour, getPercentageDifferenceInMarketCap, getAllCryptoPrices } from '../../../Services/CryptoService';
import './Prices.css';
import { Line } from 'react-chartjs-2'

const Prices = () => {
  const [data, setData] = useState('');
  const [marketCapDifference, setMarketCapDifference] = useState('');
  const [crypto, setCrypto] = useState([]);

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

    const interval = setInterval(fetchData, 20000); // Todo: set time for updating the price

    return () => clearInterval(interval);
  }, []);

  const formatPrice = (price) => {
    return parseFloat(price).toLocaleString();
  };

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


  const chartData = {
    labels: [],
    datasets: [
      {
        data: [],
        borderColor: 'green',
        fill: false,
      },
    ],
  };

  const updateChart = (price) => {
    chartData.labels.push('');
    chartData.datasets[0].data.push(price);
  };



  return (
    <>
      <div id="div-span-info">
        <span id="span-text">
          The cryptocurrency market cap today is{' '}
          <span id="special-font-market-cap">&nbsp;${formatPrice(data)}</span>, a
          <br />
          <span id="special-font-percentage">&nbsp;{marketCapDifference}%</span> change from 24 hours ago.
        </span>
      </div>

      <div id="table-container">
        <table>
          <thead>
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Price</th>
              <th>Chart</th>
              <th>Market Cap</th>
            </tr>
          </thead>
          <tbody>
            {crypto.map((crypto, index) => (
              <tr key={crypto.id}>
                <td>{index + 1}</td>
                <td>{crypto.name}</td>
                <td>${formatPrice(crypto.price)}</td>
                <td>
                <Line data={chartData} options={{ responsive: true, maintainAspectRatio: false }} />
                </td>
                <td>${formatPrice(crypto.volumeFor24Hour)}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default Prices;
