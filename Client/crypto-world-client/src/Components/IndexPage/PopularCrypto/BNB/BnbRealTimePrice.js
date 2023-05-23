import './BnbRealTimePrice.css'
import '../Utils/Utils.css'
import BNBImg from '../../../../Images/BNB.png'


const BnbRealTimePrice = () => {



    return (

        <div id='bnb-container'>

            <img id='logo-position' src={BNBImg}></img>

            <p id='item-name-position'>BNB</p>

            <p id='real-time-price'>309.00 $</p>

            <button id='buy-button'>Buy</button>

        </div>

    );

}


export default BnbRealTimePrice;