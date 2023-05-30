import './IndexPage.css'
import GetStarted from './GetStarted/GetStarted';
import BitcoinRealTimePrice from './PopularCrypto/Bitcoin/BitcoinRealTimePrice';
import EthereumRealTimePrice from './PopularCrypto/Ethreum/EthereumRealTimePrice';
import BnbRealTimePrice from './PopularCrypto/BNB/BnbRealTimePrice';
import TetherRealTimePrice from './PopularCrypto/Tether/TetherRealTimePrice';
import { useAuthContext } from '../../Context/AuthContext';
import cryptoGirlImg from '../../Images/crypto-girl-image.PNG'
import holdEarnImg from '../../Images/hold-and-earn-img.PNG'

const IndexPage = () => {


    return (

        <div className='index-page' id='container-index-page '>

            <div className='get-started'>
                <GetStarted />
            </div>


            <div id='information-div'>


                <div id='crypto-girl-div'>

                    <img id='crypto-girl-img' src={cryptoGirlImg}></img>

                </div>

                <div id='crypto-information'>



                    <p><span id='bold-text-welcome'>Welcome to Crypto World</span>, <br></br> your go-to destination for <span id='bold-text'>crypto trading</span> and market information.
                        Stay updated with real-time data, charts, and analysis. Discover a wide range of <span id='bold-text'>cryptocurrencies</span>, explore trading pairs, and diversify your portfolio.
                        Join the crypto community, access advanced tools, and embark on an exciting trading journey.
                        Start today and unleash the potential of digital assets!</p>

                </div>



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

            <p id='p-hold-earn'>Hold and Earn</p>


            <div id='information-div'>

                <div className='hold-and-earn-img'>

                    <img id='hold-and-earn-img' src={holdEarnImg}></img>

                </div>


                <div id='crypto-information'>
                    <p id="hold-earn-text">Discover the potential of <span id='bold-text-hold-and-earn'>Hold and Earn</span> crypto with our platform.
                        By holding onto your chosen cryptocurrencies, you can unlock a variety of earning opportunities.
                        Stake your assets in proof-of-stake networks, lend them to borrowers for interest, or participate in yield farming on decentralized platforms.
                        Take <span id='bold-text-hold-and-earn'>advantage</span> of the power of compounding and watch your crypto portfolio grow.
                        Whether you're a long-term investor or looking for additional income streams, our platform offers a range of options to suit your needs.
                        Start earning passive income with crypto today and make your assets work for you.</p>

                </div>



            </div>





        </div>





    );

}

export default IndexPage;