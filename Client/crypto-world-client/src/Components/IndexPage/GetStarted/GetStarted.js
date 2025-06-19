import React from 'react';
import { useSpring, animated, useSprings } from '@react-spring/web';
import { Link } from 'react-router-dom';
import './GetStarted.css';

const cryptoAssets = [
  { name: 'Bitcoin', color: '#f7931a' },
  { name: 'Ethereum', color: '#3c3c3d' },
  { name: 'Binance', color: '#f3ba2f' },
  { name: 'Cardano', color: '#0033ad' },
  { name: 'Tether', color: '#26a17b' },
  { name: 'Solana', color: '#00ffa3' },
  { name: 'Ripple', color: '#346aa9' },
  { name: 'Polkadot', color: '#e6007a' },
  { name: 'Dogecoin', color: '#c2a633' },
  { name: 'USDC', color: '#2775ca' },
];

// Random helper function
const getRandom = (min, max) => Math.random() * (max - min) + min;

const GetStarted = () => {
  // Slower animation and smaller floating area (10% to 85% so it doesn't fill entire height)
  const [springs] = useSprings(cryptoAssets.length, index => ({
    from: {
      x: getRandom(10, 85),
      y: getRandom(10, 60),
      opacity: 0,
      scale: 0.8,
    },
    to: async (next) => {
      while (true) {
        await next({
          x: getRandom(10, 85),
          y: getRandom(10, 60),
          opacity: 1,
          scale: 1.1,
          config: { mass: 1, tension: 60, friction: 20 }, // slower and smooth
          delay: getRandom(0, 3000),
        });
        await next({
          opacity: 0.6,
          scale: 0.9,
          config: { mass: 1, tension: 50, friction: 25 },
          delay: getRandom(1500, 3000),
        });
      }
    },
  }));

  return (
    <div className="getStartedContainer">
      {/* Floating crypto asset names */}
      {springs.map((styles, i) => (
        <animated.div
          key={cryptoAssets[i].name}
          className="floatingCrypto"
          style={{
            ...styles,
            position: 'absolute',
            top: styles.y.to(y => `${y}%`),
            left: styles.x.to(x => `${x}%`),
            transform: styles.scale.to(s => `scale(${s})`),
            backgroundColor: cryptoAssets[i].color,
            boxShadow: `0 4px 10px ${cryptoAssets[i].color}80`,
          }}
        >
          {cryptoAssets[i].name}
        </animated.div>
      ))}

      {/* Get Started Button */}
      <div className="buttonWrapper">
        <Link to="/register" className="getStartedButton">
          Get Started
        </Link>
      </div>
    </div>
  );
};

export default GetStarted;
