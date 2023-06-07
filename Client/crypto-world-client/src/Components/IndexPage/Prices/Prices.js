import { getMarketCap24Hour } from '../../../Services/CryptoService';
import { useState, useEffect } from 'react';
import './Prices.css'


const Prices = () => {

    const [data, setData] = useState('');
    const [marketCapDifference, setMarketCapDifference] = useState('');

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
    
        const interval = setInterval(fetchData, 55000); // Todo: set time for updating the price
    
    
        return () => clearInterval(interval);
      }, []);
    
    
      const formatPrice = (price) => {
        return parseFloat(price).toLocaleString(); 
      };


    return (




        <>

            <div id="div-span-info">
                <span id="span-text">The cryptocurrency market cap today is

                    <span id="special-font-market-cap">&nbsp;${formatPrice(data)}</span>

                    , a<br />

                    <span id='special-font-percentage'>&nbsp;+0.63%</span>

                    &nbsp; change from 24 hours ago.

                </span>
            </div>




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
                    <tr>
                        <td>1</td>
                        <td>Bitcoin</td>
                        <td>$58,752.34</td>
                        <td></td>
                        <td>$1,094,208,374,559</td>
                    </tr>

                </tbody>
            </table>

        </>

    );
}

export default Prices;