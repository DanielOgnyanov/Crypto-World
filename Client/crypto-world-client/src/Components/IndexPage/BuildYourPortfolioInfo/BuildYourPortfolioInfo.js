import './BuildYourPortfolioInfo.css';
import verifyImg from '../../../Images/verify-img.jpg';
import fundImg from '../../../Images/fund-img.jpg';
import tradingImg from '../../../Images/trading-img.jpg';

const BuildYourPortfolioInfo = () => {
  return (
    <section className="build-portfolio-section">
      <p className="build-title">Build your crypto portfolio</p>
      <span className="build-subtitle">Start your first trade with these easy steps.</span>

      <div className="steps-container">
        <div className="step-card">
          <img className="step-image" src={verifyImg} alt="Verify Identity" />
          <p className="step-title">Verify your identity</p>
          <p className="step-description">
            Complete the identity verification process to secure your account and transactions.
          </p>
        </div>

        <div className="step-card">
          <img className="step-image" src={fundImg} alt="Fund Account" />
          <p className="step-title">Fund your account</p>
          <p className="step-description">
            Add funds to your crypto account to start trading crypto. You can add funds with a variety of payment methods.
          </p>
        </div>

        <div className="step-card">
          <img className="step-image" src={tradingImg} alt="Start Trading" />
          <p className="step-title">Start trading</p>
          <p className="step-description">
            You're good to go! Buy/sell crypto, set up recurring buys for your investments.
            Discover what Crypto World has to offer.
          </p>
        </div>
      </div>
    </section>
  );
};

export default BuildYourPortfolioInfo;
