import './BitcoinRealTimePrice.css'
import '../Utils/Utils.css'
import * as cryptoService from '../../../../Services/CryptoService'
import BitcoinImg from '../../../../Images/Bitcoin.png'
import { getPopularCryptoPrice } from '../../../../Services/CryptoService'
import { useState, useEffect } from 'react';


const BitcoinRealTimePrice = () => {

    const [data, setData] = useState([]);
    const [filteredPrice, setFilteredPrice] = useState('');

    useEffect(() => {
        getPopularCryptoPrice()
          .then(fetchResult => {
            setData(fetchResult);
          })
          .catch(error => {
            console.error('Error fetching data:', error);
          });
      }, []);
    
      
      useEffect(() => {
        
        const filteredData = data.filter(item => item.name === 'Bitcoin');
    
        if (filteredData.length > 0) {
          const price = filteredData[0].price.toFixed(2);
          setFilteredPrice(price);
        }
      }, [data]);

    return (

       <div id='container-crypto-price-table'>

        <img id='logo-position' src = {BitcoinImg}></img>

        <p id='item-name-position'>Bitcoin</p>

        <p id='real-time-price'>{filteredPrice} $</p>

        <button id='buy-button'>Buy</button>

       </div>

);

}


export default BitcoinRealTimePrice;