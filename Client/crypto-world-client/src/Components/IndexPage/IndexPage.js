import './IndexPage.css'
import GetStarted from './GetStarted/GetStarted';
import BitcoinRealTimePrice from './PopularCrypto/Bitcoin/BitcoinRealTimePrice';
import { useAuthContext } from '../../Context/AuthContext';

const IndexPage = () => {


    return (

        <div className='index-page' id='container-index-page '>

            <div className='get-started'>
                <GetStarted />
            </div>

            <div className='table-crypto-price'>
                <p id='p-popular-crypto'>Popular Crypto</p>
                <BitcoinRealTimePrice/>
            </div>



        </div>





    );

}

export default IndexPage;