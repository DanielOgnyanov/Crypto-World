import './GetStarted.css'
import { Link } from 'react-router-dom'
import IndexPageBg from './IndexPageBg/IndexPageBg'
import { useSpring, animated, config } from '@react-spring/web'

const GetStarted = () => {
const containerSpring = useSpring({
    from: { opacity: 0, transform: 'translateY(30px)' },
    to: { opacity: 1, transform: 'translateY(0)' },
    config: config.gentle,
    delay: 200
  });

  const buttonSpring = useSpring({
    from: { opacity: 0, transform: 'scale(0.9)' },
    to: { opacity: 1, transform: 'scale(1)' },
    config: config.wobbly,
    delay: 600
  });

  return (
    <div id="container">
      <animated.div className="getStarted" id="getStarted-div" style={containerSpring}>
        <h1>Buy Bitcoin & Crypto Asset</h1>
        <p>
          Sign up today and <strong>buy top 10 cryptocurrencies</strong>, <br />
          easily and fast. Get started with as little as <strong>$10.</strong>
        </p>

        <animated.div className="getStartedButton" id="getStartedButton-div" style={buttonSpring}>
          <Link className="button" to="/register">Get Started</Link>
        </animated.div>
      </animated.div>

      <IndexPageBg />
    </div>
  );
};

export default GetStarted;
