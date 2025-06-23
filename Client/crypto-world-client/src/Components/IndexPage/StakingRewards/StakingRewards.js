import './StakingRewards.css';
import { useNavigate } from "react-router-dom";

const StakingRewards = () => {
  const history = useNavigate();

  const registerHandler = () => {
    history('/register');
  };

  return (
    <div className="staking-page">
      <div className="staking-content">
        <h1 className="staking-title">
          Earn up to <span className="highlight">24% annually</span> on your crypto holdings
        </h1>

        <p className="staking-text">
          Staking is a way of earning rewards for holding certain cryptocurrencies. When you stake your crypto,
          you're helping to support the network by locking your assets in a blockchain protocol. In return, you earn staking rewards — similar to earning interest in a traditional savings account.
          <br /><br />
          Our platform offers flexible staking with no lock-in periods, and rewards are paid out automatically
          twice per week. Whether you're new to crypto or a seasoned investor, staking is one of the easiest ways to make your assets work for you.
          <br /><br />
          Start staking today and watch your earnings grow while contributing to the future of decentralized finance.
        </p>

        <div className="staking-button-wrapper">
          <button onClick={registerHandler} className="staking-button">
            Create Account
          </button>
        </div>
      </div>

      
    </div>
  );
};

export default StakingRewards;
