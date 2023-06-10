import { getMarketCap24Hour, getPercentageDifferenceInMarketCap, getAllCryptoPrices } from '../../../Services/CryptoService';
import { useState, useEffect, useRef } from 'react';
import './Prices.css'
import Chart from 'chart.js';


const Prices = () => {

    const [data, setData] = useState('');
    const [marketCapDifference, setMarketCapDifference] = useState('');
    const [crypto, setCrypto] = useState([]);
    const chartRef = useRef(null);

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

    useEffect(() => {

        if (chartRef.current && crypto.length > 0) {
            const cryptoNames = crypto.map((crypto) => crypto.name);
            const cryptoPrices = crypto.map((crypto) => crypto.price);

            const chartConfig = {
                type: 'line',
                data: {
                    labels: cryptoNames,
                    datasets: [{
                        label: 'Price',
                        data: cryptoPrices,
                        backgroundColor: 'rgba(0, 123, 255, 0.4)',
                        borderColor: 'rgba(0, 123, 255, 1)',
                        borderWidth: 2,
                        pointRadius: 0,
                        fill: true,
                    }],
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: false,
                    scales: {
                        y: {
                            ticks: {
                                callback: (value) => `$${value}`,
                            },
                        },
                    },
                },
            };

            new Chart(chartRef.current, chartConfig);
        }
    }, [crypto]);





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
                                    <canvas ref={chartRef}></canvas>
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