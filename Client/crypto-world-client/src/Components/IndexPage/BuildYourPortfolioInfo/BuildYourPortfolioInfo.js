import './BuildYourPortfolioInfo.css'
import verifyImg from '../../../Images/verify-img.jpg'


const BuildYourPortfolioInfo = () => {


    return (

        <>

            <p id='p-build-your-crypto-portfolio'>Build your crypto portfolio</p>

            <span id='span-step-info'>Start your first trade with these easy steps.</span>

            <div id='info-display-block-inline'>
                <img id='img-step' src={verifyImg}></img>

                <p id='p-step-title'>Verify your identity</p> 
                <br>
                </br>
                
            </div>
            <p id='p-text'>Complete the identity verification process to secure your account and transactions.</p>






        </>




    );

}

export default BuildYourPortfolioInfo;