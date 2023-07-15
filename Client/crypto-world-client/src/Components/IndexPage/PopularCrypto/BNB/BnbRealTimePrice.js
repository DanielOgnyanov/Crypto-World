import './BnbRealTimePrice.css'
import '../Utils/Utils.css'
import BNBImg from '../../../../Images/BNB.png'
import { getPopularCryptoPrice } from '../../../../Services/CryptoService'
import { useState, useEffect } from 'react';


const BnbRealTimePrice = () => {

    const [data, setData] = useState([]);
    const [filteredPrice, setFilteredPrice] = useState('');

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
          setFilteredPrice(price);
        }
      }, [data]);


    return (

        <div id='bnb-container'>

            <img id='logo-position' src='https://s2.coinmarketcap.com/static/img/coins/64x64/1839.png' alt='BNB Logo'></img>

            <p id='item-name-position'>BNB</p>

            <p id='real-time-price'>{filteredPrice} $</p>

            <button id='buy-button'>Buy</button>

        </div>

    );

}


export default BnbRealTimePrice;