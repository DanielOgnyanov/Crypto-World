import './IndexPage.css'
import GetStarted from './GetStarted/GetStarted';
import BitcoinRealTimePrice from './TableCryptoPrice/BitcoinRealTimePrice';
import { useAuthContext } from '../../Context/AuthContext';

const IndexPage = () => {


    return (

        <div className='index-page' id='container-index-page '>

            <div className='get-started'>
                <GetStarted />
            </div>

            <div className='table-crypto-price'>
                <BitcoinRealTimePrice/>
            </div>



        </div>





    );

}

export default IndexPage;