import React from 'react';
import { useSpring, animated } from '@react-spring/web';
import './HoldAndEarn.css';
import holdEarnImg from '../../../Images/hold-and-earn-img.PNG';

const HoldAndEarn = () => {
  // React Spring animation for the title
  const titleAnimation = useSpring({
    loop: { reverse: true },
    from: { transform: 'translateX(-20px)', opacity: 0.8 },
    to: { transform: 'translateX(20px)', opacity: 1 },
    config: { duration: 2000 },
  });

  return (
    <div className="hold-and-earn-container">
      <div className="hold-and-earn-img">
        <img
          id="hold-and-earn-img"
          src={holdEarnImg}
          alt="Hold and Earn"
        />
      </div>

      <div id="crypto-information">
        <animated.h2 style={titleAnimation} className="hold-earn-title">
          Hold and Earn
        </animated.h2>

        <p id="hold-earn-text">
          Discover the potential of{' '}
          <span id="bold-text-hold-and-earn">Hold and Earn</span> crypto with our platform.
          By holding onto your chosen cryptocurrencies, you can unlock a variety of earning
          opportunities. Stake your assets in proof-of-stake networks, lend them to borrowers
          for interest, or participate in yield farming on decentralized platforms. Take{' '}
          <span id="bold-text-hold-and-earn">advantage</span> of the power of compounding and
          watch your crypto portfolio grow. Whether you're a long-term investor or looking
          for additional income streams, our platform offers a range of options to suit your
          needs. Start earning passive income with crypto today and make your assets work for
          you.
        </p>
      </div>
    </div>
  );
};

export default HoldAndEarn;
