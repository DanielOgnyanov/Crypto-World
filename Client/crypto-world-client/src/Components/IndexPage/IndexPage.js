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

            <section id='crypto-information'>

            <p><span id='bold-text-welcome'>Welcome to Crypto World</span>, <br></br> your go-to destination for <span id='bold-text'>crypto trading</span> and market information. 
            Stay updated with real-time data, charts, and analysis. Discover a wide range of <span id='bold-text'>cryptocurrencies</span>, explore trading pairs, and diversify your portfolio. 
            Join the crypto community, access advanced tools, and embark on an exciting trading journey. 
            Start today and unleash the potential of digital assets!</p>

            </section>

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