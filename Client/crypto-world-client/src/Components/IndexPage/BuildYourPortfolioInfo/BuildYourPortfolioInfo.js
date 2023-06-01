import './BuildYourPortfolioInfo.css'
import verifyImg from '../../../Images/verify-img.jpg'
import fundImg from '../../../Images/fund-img.jpg'


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






        </>




    );

}

export default BuildYourPortfolioInfo;