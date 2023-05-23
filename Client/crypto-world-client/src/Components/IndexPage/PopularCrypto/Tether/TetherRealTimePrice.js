import '../Utils/Utils.css'
import './TetherRealTimePrice.css'

import TetherImg from '../../../../Images/Tether.png'



const TetherRealTimePrice = () => {



    return (

       <div id='tether-container'>

        <img id='logo-position' src = {TetherImg}></img>

        <p id='item-name-position'>Tether</p>

        <p id='real-time-price'>1.00 $</p>

        <button id='buy-button'>Buy</button>
        

       </div>

);

}


export default TetherRealTimePrice;