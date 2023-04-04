import './HomePage.css'
import * as cryptoService from '../../Services/CryptoService'
import Chart from '../Chart/Chart';
import WalletDetails from '../WalletDetails/WalletDetails';
import UserDetails from './UserDetails/UserDetails';
import { useEffect, useState } from 'react';







const HomePage = (e) => {

    const cryptoPrices = cryptoService.getCryptoPrice;
    
    const cryptoItem =
        [{ id: 1, name: "Bitcoin", price: 45000 },
         { id: 2, name: "Ethereum", price: 3000 }];



    return (

        <div className='home' id='home'>

            <div className='user-info-welcome'>
                <UserDetails/>

            </div>

            <div className='chart'>
                <Chart />
            </div>

            <div className='wallet-details'>
                <WalletDetails />
            </div>

            <table id='table-homepage'>
                <thead >
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Crypto Name</th>
                        <th scope="col">Current Price</th>
                    </tr>
                </thead>
                <tbody>
                    {cryptoItem.map(Item => (

                        <tr>
                            <th scope="row" >{Item.id}</th>
                            <td >{Item.name}</td>
                            <td >{Item.price}</td>
                        </tr>


                    ))}

                </tbody>
            </table>

        </div>
    );
}


export default HomePage;