import React from 'react';
import './ServicesInfo.css';

const Services = () => {
  return (
    <div className="services-container">
      <h1 className="services-title">Our Services</h1>
      <p className="services-intro">
        Welcome to Crypto World! Here’s what you can do on our platform:
      </p>
      <ul className="services-list">
        <li>Track real-time prices of popular cryptocurrencies like Bitcoin, Ethereum, and more.</li>
        <li>Build and manage your own crypto portfolio easily and securely.</li>
        <li>Access educational resources to learn about cryptocurrency trading and investing.</li>
        <li>Discover opportunities for staking, lending, and earning passive income with your crypto assets.</li>
        <li>Use our secure platform to buy and sell cryptocurrencies with confidence.</li>
      </ul>

      <h2 className="services-subtitle">Important Investing Advice</h2>
      <p className="services-advice-intro">
        Cryptocurrency investing can be exciting but also volatile. We strongly recommend that you:
      </p>
      <ul className="services-advice-list">
        <li>Only invest money that you can afford to lose without impacting your daily life.</li>
        <li>Do your own research and understand the risks before buying or trading any crypto asset.</li>
        <li>Consider diversifying your investments and avoid putting all your funds into a single cryptocurrency.</li>
        <li>Start with small amounts and increase your investment gradually as you gain confidence and knowledge.</li>
        <li>Be cautious of scams and always use secure platforms and wallets.</li>
      </ul>

      <p className="services-footer-note">
        Your financial safety and education are our top priorities. Please invest wisely!
      </p>
    </div>
  );
};

export default Services;
