import '../Utils/Utils.css'
import './TetherRealTimePrice.css'
import { getPopularCryptoPrice } from '../../../../Services/CryptoService'
import { useState, useEffect } from 'react';

import TetherImg from '../../../../Images/Tether.png'



const TetherRealTimePrice = () => {

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
        
        const filteredData = data.filter(item => item.name === 'Tether');
    
        if (filteredData.length > 0) {
          const price = filteredData[0].price.toFixed(2);
          setFilteredPrice(price);
        }
      }, [data]);

    return (

       <div id='tether-container'>

        <img id='logo-position' src = {TetherImg}></img>

        <p id='item-name-position'>Tether</p>

        <p id='real-time-price'>{filteredPrice} $</p>

        <button id='buy-button'>Buy</button>
        

       </div>

);

}


export default TetherRealTimePrice;