import './BitcoinRealTimePrice.css'
import '../Utils/Utils.css'
import * as cryptoService from '../../../../Services/CryptoService'
import BitcoinImg from '../../../../Images/Bitcoin.png'
import { getPopularCryptoPrice } from '../../../../Services/CryptoService'


const BitcoinRealTimePrice = () => {

    


    return (

       <div id='container-crypto-price-table'>

        <img id='logo-position' src = {BitcoinImg}></img>

        <p id='item-name-position'>Bitcoin</p>

        <p id='real-time-price'>28.000.00 $</p>

        <button id='buy-button'>Buy</button>

       </div>

);

}


export default BitcoinRealTimePrice;