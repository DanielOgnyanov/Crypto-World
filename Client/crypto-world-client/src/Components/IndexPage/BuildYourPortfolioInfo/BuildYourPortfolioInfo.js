import './BuildYourPortfolioInfo.css'
import verifyImg from '../../../Images/verify-img.jpg'
import fundImg from '../../../Images/fund-img.jpg'
import tradingImg from '../../../Images/trading-img.jpg'


const BuildYourPortfolioInfo = () => {


    return (

        <>

            <p id='p-build-your-crypto-portfolio'>Build your crypto portfolio</p>

            <span id='span-step-info'>Start your first trade with these easy steps.</span>

            <div id='info-display-block-inline'>
                <img id='img-step' src={verifyImg}></img>

                <p id='p-step-title'>Verify your identity</p>

            </div>
            <p id='p-text'>Complete the identity verification process to secure your account and transactions.</p>

            <div id='info-display-block-inline'>
                <img id='img-step' src={fundImg}></img>

                <p id='p-step-title'>Fund your account</p>

            </div>
            <p id='p-text'>Add funds to your crypto account to start trading crypto. You can add funds with a variety of payment methods.</p>


            <div id='info-display-block-inline'>
                <img id='img-step' src={tradingImg}></img>

                <p id='p-step-title'>Start trading</p>

            </div>
            <p id='p-text'>You're good to go! Buy/sell crypto, set up recurring buys for your investments.
                <br></br> Discover what Crypto World has to offer.</p>



        </>




    );

}

export default BuildYourPortfolioInfo;