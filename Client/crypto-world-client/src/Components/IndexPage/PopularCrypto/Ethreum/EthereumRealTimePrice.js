import '../Utils/Utils.css'
import './EthereumRealTimePrice.css'
import { getPopularCryptoPrice } from '../../../../Services/CryptoService'
import { useState, useEffect } from 'react';



const EthereumRealTimePrice = () => {

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
        
        const filteredData = data.filter(item => item.name === 'Ethereum');
    
        if (filteredData.length > 0) {
          const price = filteredData[0].price.toFixed(2);
          setImage(filteredData[0].logoImage)
          setFilteredPrice(price);
        }
      }, [data]);

    return (

       <div id='eth-container'>

        <img id='logo-position' src = {image}></img>

        <p id='item-name-position'>Ethereum</p>

        <p id='real-time-price'>{filteredPrice} $</p>

        <button id='buy-button'>Buy</button>
        

       </div>

);

}


export default EthereumRealTimePrice;