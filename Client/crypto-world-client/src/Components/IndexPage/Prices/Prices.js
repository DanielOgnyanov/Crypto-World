import { useState, useEffect } from 'react';
import { getMarketCap24Hour, getPercentageDifferenceInMarketCap, getAllCryptoPrices, getListOfCryptoPrices } from '../../../Services/CryptoService';
import './Prices.css';
import { Line } from 'react-chartjs-2'

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




  const [chartData, setChartData] = useState({
    labels: [],
    datasets: [
      {
        data: [],
        borderColor: 'green',
        fill: false,
      },
    ],
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const fetchResult = await getListOfCryptoPrices();

        console.log('Fetched data:', fetchResult);

        const labels = fetchResult.map((crypto) => {
          if (crypto[0].recordedAt && crypto[0].recordedAt.length > 0) {
            const dateTimeString = crypto[0].recordedAt;
            const dateTime = new Date(dateTimeString);
            const formattedTime = dateTime.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });

            return crypto[0].recordedAt.map((time) => new Date(time).toLocaleTimeString());;
          }
          return null;

        });


        const data = fetchResult.map((crypto) => {
          if (crypto[0].price && crypto[0].price.length > 0) {
            return crypto[0].price;
          }
          return null;
        });

        setUpdatedLabels(labels);
        setUpdatedData(data);

        console.log('Formatted Time', updatedLabels)
        setChartData((prevChartData) => ({
          ...prevChartData,
          labels: updatedLabels,
          datasets: [
            {
              ...prevChartData.datasets[0],
              data: updatedData,
            },
          ],
        }));
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();

    const interval = setInterval(fetchData, 50000);

    return () => clearInterval(interval);
  }, []);




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
                <td>
                  <img src={crypto.logoImage} alt={crypto.name} />
                  {crypto.name}

                </td>
                <td>${formatPrice(crypto.price)}</td>
                <td>

                  <Line
                    data={{
                      labels: updatedLabels[index],
                      datasets: [
                        {
                          data: updatedData[index],
                          borderColor: 'green',
                          fill: false,
                        },
                      ],
                    }}
                    options={{ responsive: true, maintainAspectRatio: false, }}
                  />
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
