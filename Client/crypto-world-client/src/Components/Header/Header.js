import './Header.css'
import { Link } from 'react-router-dom'
import { useNavigate } from "react-router-dom";
import { useState } from 'react';



const Header = () => {

    const history = useNavigate();
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const usernameCheck = localStorage.getItem("usernameLogin");

    function handleClick() {
        history('/register');
    }

    function signInHandler() {
        history('/login')
    }

    function logout() {

        localStorage.removeItem("usernameLogin");
        history('/')

    }

    console.log()

    let userNavigation = (

        <div className='userNavigation'>

            <Link to="/"><span id='logo-header'>Crypto World</span></Link>

            <div id='navigaion-a-div'>
                <Link id='navigation-a' to="/home" data-toggle="collapse">Home</Link>
                <Link id='navigation-a' to="/admin" data-toggle="collapse">Admin</Link>

                <Link id='navigation-a' to="/add-credit-card">Add Credit Card</Link>
                <Link id='navigation-a' to="/buy-crypto">Buy Crypto</Link>
                <Link id='navigation-a' to="/sell-crypto">Sell Crypto</Link>
            </div>


            <button onClick={logout} type='submit' id='logout-button'>Logout</button>

        </div>

    );


    let guestNavigation = (

        <div className='guestNavigation'>

            <Link to="/"><span id='logo-header'>Crypto World</span></Link>

            <button onClick={signInHandler} type='submit' id='navigation-button-signin'>Sign In</button>

            <button onClick={handleClick} type='submit' id='navigation-button-create'>Create Account</button>


        </div>

    );


    return (

        <header>
            <nav id='navigation'>

                {isAuthenticated

                    ? userNavigation
                    : guestNavigation
                }
            </nav>

        </header >
    );
}

export default Header;