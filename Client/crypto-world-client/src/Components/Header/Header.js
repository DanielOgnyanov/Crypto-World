import "./Header.css";
import { Link, useNavigate } from "react-router-dom";
import { useAuthContext } from "../../Context/AuthContext";
import { getUser } from "../../Services/AuthService";

const Header = () => {
  const history = useNavigate();
   const user = getUser();

  function registerHandler() {
    history("/register");
  }

  function signInHandler() {
    history("/login");
  }

  const userNavigation = (
    <div className="userNavigation">
      <Link to="/home">
        <span id="logo-header">Crypto World</span>
      </Link>

      <div id="navigaion-a-div">
        <Link id="navigation-a" to="/home">
          Home
        </Link>
        <Link id="navigation-a" to="/admin">
          Admin
        </Link>
        <Link id="navigation-a" to="/add-credit-card">
          Add Credit Card
        </Link>
        <Link id="navigation-a" to="/buy-crypto">
          Buy Crypto
        </Link>
        <Link id="navigation-a" to="/sell-crypto">
          Sell Crypto
        </Link>
      </div>

      <Link id="logout-link" to="/logout">
        <button type="submit" id="logout-button">
          Logout
        </button>
      </Link>
    </div>
  );

  const guestNavigation = (
    <div className="guestNavigation">
      <Link to="/" id="logo-header">
        Crypto World
      </Link>

      <div id="guest-menu-wrapper">
        <Link to="/prices" id="guest-menu">
          Prices
        </Link>
        <Link to="/staking-rewards" id="guest-menu">
          Staking Rewards
        </Link>
      </div>

      <div id="auth-buttons">
        <button
          onClick={signInHandler}
          type="submit"
          id="navigation-button-signin"
        >
          Sign In
        </button>
        <button
          onClick={registerHandler}
          type="submit"
          id="navigation-button-create"
        >
          Create Account
        </button>
      </div>
    </div>
  );

  return (
   <header>
    <nav id="navigation">
      {user ? userNavigation : guestNavigation}
    </nav>
  </header>
  );
};

export default Header;
