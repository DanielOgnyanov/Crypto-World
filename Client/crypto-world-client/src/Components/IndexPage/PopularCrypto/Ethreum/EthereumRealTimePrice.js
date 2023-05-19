import './EthereumRealTimePrice.css'
import EthereumImg from '../../../../Images/Ethereum.png'



const EthereumRealTimePrice = () => {



    return (

       <div id='eth-container'>

        <img id='eth-logo' src = {EthereumImg}></img>

        <p id='item-name-position'>Ethereum</p>

        <p id='real-time-price'>1.800.00 $</p>
        

       </div>

);

}


export default EthereumRealTimePrice;