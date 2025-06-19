import '../Utils/Utils.css'
import '../Utils/CryptoCard.css'
import { getPopularCryptoPrice } from '../../../../Services/CryptoService'
import { useState, useEffect } from 'react';

const BnbRealTimePrice = () => {
  const [data, setData] = useState([]);
  const [filteredPrice, setFilteredPrice] = useState('');
  const [image, setImage] = useState('');

  useEffect(() => {
    const fetchData = async () => {
      try {
        const fetchResult = await getPopularCryptoPrice();
        setData(fetchResult);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();

    const interval = setInterval(fetchData, 55000);

    return () => clearInterval(interval);
  }, []);

  useEffect(() => {
    const filteredData = data.filter(item => item.name === 'Binance');

    if (filteredData.length > 0) {
      const price = filteredData[0].price.toFixed(2);
      setImage(filteredData[0].logoImage);
      setFilteredPrice(price);
    }
  }, [data]);

  return (
    <div className="crypto-price-card">
      <img className="crypto-logo" src={image} alt="BNB Logo" />
      <p className="crypto-name">BNB</p>
      <p className="crypto-price">{filteredPrice} $</p>
      <button className="buy-btn">Buy</button>
    </div>
  );
};

export default BnbRealTimePrice;
