import './BitcoinRealTimePrice.css'
import * as cryptoService from '../../../Services/CryptoService'
import BitcoinImg from '../../../Images/Bitcoin.png'

const BitcoinRealTimePrice = () => {



    return (

       <div id='container-crypto-price-table'>

        <img id='bitcoin-logo' src = {BitcoinImg}></img>

        <p id='item-name-position'>Bitcoin</p>

        <span>28.000.00</span>

       </div>

);

}


export default BitcoinRealTimePrice;