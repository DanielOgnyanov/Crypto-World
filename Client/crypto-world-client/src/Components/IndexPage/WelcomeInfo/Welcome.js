import './Welcome.css'
import cryptoGirlImg from '../../../Images/crypto-girl-image.PNG'

const Welcome = () => {
  return (
    <section className="welcome-section">
      <div className="welcome-image-wrapper">
        <img className="welcome-image" src={cryptoGirlImg} alt="Crypto Girl" />
      </div>

      <div className="welcome-content">
        <h2>Welcome to <span className="highlight">Crypto World</span></h2>
        <p>
          Your go-to destination for <strong>crypto trading</strong> and market insights.
          Stay updated with real-time charts, analytics, and price movements.
        </p>
        <p>
          Explore a variety of <strong>cryptocurrencies</strong>, discover trading pairs, and diversify your portfolio with confidence.
        </p>
        <p>
          Join a vibrant community, use cutting-edge tools, and start your crypto journey today!
        </p>
      </div>
    </section>
  )
}

export default Welcome
