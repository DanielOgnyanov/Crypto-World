import '../Utils/Utils.css'
import './EthereumRealTimePrice.css'

import EthereumImg from '../../../../Images/Ethereum.png'



const EthereumRealTimePrice = () => {



    return (

       <div id='eth-container'>

        <img id='logo-position' src = {EthereumImg}></img>

        <p id='item-name-position'>Ethereum</p>

        <p id='real-time-price'>1.800.00 $</p>

        <button id='buy-button'>Buy</button>
        

       </div>

);

}


export default EthereumRealTimePrice;