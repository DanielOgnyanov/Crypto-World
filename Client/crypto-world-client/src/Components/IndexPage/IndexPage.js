import './IndexPage.css'
import GetStarted from './GetStarted/GetStarted';
import BitcoinRealTimePrice from './PopularCrypto/Bitcoin/BitcoinRealTimePrice';
import EthereumRealTimePrice from './PopularCrypto/Ethreum/EthereumRealTimePrice';
import BnbRealTimePrice from './PopularCrypto/BNB/BnbRealTimePrice';
import TetherRealTimePrice from './PopularCrypto/Tether/TetherRealTimePrice';
import { useAuthContext } from '../../Context/AuthContext';

const IndexPage = () => {


    return (

        <div className='index-page' id='container-index-page '>

            <div className='get-started'>
                <GetStarted />
            </div>

            <p id='p-popular-crypto'>Popular Crypto</p>

            <div id='container-popular-crypto'>

                <BitcoinRealTimePrice />
                <EthereumRealTimePrice />
                
            </div>

            <div id='container-popular-crypto'>
                <BnbRealTimePrice />
                <TetherRealTimePrice />
            </div>



        </div>





    );

}

export default IndexPage;