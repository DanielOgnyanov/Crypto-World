import './StakingRewards.css'
import { useNavigate } from "react-router-dom";


const StakingRewards = () => {

  const history = useNavigate();

  function registerHandler() {
    history('/register');
  }

  return (

    <>
      <div id='body-content'>

        <h1 id='title'>

          <span>
            <strong>Earn up to 24% </strong>
            yearly on your crypto
          </span>
        </h1>
        
  <p>
          Staking gives you the power to earn rewards on your cash and crypto holdings.
          Start staking in just a couple of clicks and automatically earn rewards twice a week.
          Instantly unstake at any time with no penalties.
        </p>

        <button onClick={registerHandler} type='submit' id='stacking-rewards-button-create'>Create Account</button>

      </div>

    </>


  );

}


export default StakingRewards;