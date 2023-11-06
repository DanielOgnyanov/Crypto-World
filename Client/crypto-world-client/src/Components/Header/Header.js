import './Header.css'
import { Link } from 'react-router-dom'
import { useNavigate } from "react-router-dom";
import * as authService from '../../Services/AuthService'
import { useAuthContext } from '../../Context/AuthContext';



const Header = () => {

    const history = useNavigate();

    const { user, login, logout } = useAuthContext();




    function registerHandler() {
   
       history('/register');
    }

    function signInHandler() {
        history('/login')
    }

    let userNavigation = (

        <div className='userNavigation' >

            <Link to="/home"><span id='logo-header'>Crypto World</span></Link>

            <div id='navigaion-a-div'>

                <Link id='navigation-a' to="/home" data-toggle="collapse">Home</Link>
                <Link id='navigation-a' to="/admin" data-toggle="collapse">Admin</Link>

                <Link id='navigation-a' to="/add-credit-card">Add Credit Card</Link>
                <Link id='navigation-a' to="/buy-crypto">Buy Crypto</Link>
                <Link id='navigation-a' to="/sell-crypto">Sell Crypto</Link>

            </div>

            <Link id='navigation-a' to="/logout"><button type='submit' id='logout-button'>Logout</button></Link>

        </div>

    );


    let guestNavigation = (

        <div className='guestNavigation' >

            <Link to="/"><span id='logo-header'>Crypto World</span></Link>

            <Link to="/prices" id='guest-menu'>Prices</Link>
            <Link to="/staking-rewards" id='guest-menu'>Staking Rewards</Link>

            <button onClick={signInHandler} type='submit' id='navigation-button-signin'>Sign In</button>

            <button  onClick={registerHandler} type='submit' id='navigation-button-create'>Create Account</button>

        </div>

    );


    return (

        <header>

            <nav id='navigation'>

                {Boolean(authService.getUser())

                    ? userNavigation
                    : guestNavigation

                }

            </nav>


        </header >

    );
}

export default Header;