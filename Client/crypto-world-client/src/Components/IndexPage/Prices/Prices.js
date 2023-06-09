import { getMarketCap24Hour, getPercentageDifferenceInMarketCap, getAllCryptoPrices } from '../../../Services/CryptoService';
import { useState, useEffect } from 'react';
import './Prices.css'


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



    const getChartStyle = (cryptoPrice, previousPrice) => {

        if (cryptoPrice) {

            const percentage = cryptoPrice / 100;
            const color = cryptoPrice > previousPrice ? 'green' : 'red';

            return {
                background: `linear-gradient(to right, ${color} ${percentage}%, transparent ${percentage}%)`
            };
        }
        return {};
    }

    console.log(crypto)


    return (




        <>

            <div id="div-span-info">
                <span id="span-text">The cryptocurrency market cap today is

                    <span id="special-font-market-cap">&nbsp;${formatPrice(data)}</span>

                    , a<br />

                    <span id='special-font-percentage'>&nbsp;{marketCapDifference}%</span>

                    &nbsp; change from 24 hours ago.

                </span>
            </div>



            <div id='table-container'>

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
                                    <div id={`chart-1D-${crypto.id}`} style={getChartStyle(crypto.price, crypto.oldPriceTrack)}></div>
                                </td>
                                <td>${formatPrice(crypto.volumeFor24Hour)}</td>
                            </tr>
                        ))}

                    </tbody>
                </table>

            </div>

        </>

    );
}

export default Prices;