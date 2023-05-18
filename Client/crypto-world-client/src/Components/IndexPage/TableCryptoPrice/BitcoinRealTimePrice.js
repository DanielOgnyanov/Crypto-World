import './BitcoinRealTimePrice.css'
import * as cryptoService from '../../../Services/CryptoService'
import BitcoinImg from '../../../Images/Bitcoin.png'

const BitcoinRealTimePrice = () => {



    return (

       <div id='container-crypto-price-table'>

        <img src = {BitcoinImg}></img>
        <p id='item-name-position'>Bitcoin</p>

       </div>

);

}


export default BitcoinRealTimePrice;