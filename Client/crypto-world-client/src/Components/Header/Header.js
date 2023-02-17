import './Header.css'
import { Link } from 'react-router-dom'
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from 'react';
import * as authService from '../../Services/AuthService'



const Header = () => {

    const history = useNavigate();
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const usernameCheck = JSON.parse(localStorage.getItem("usernameLogin"));
    
    useEffect(() => {

        if (usernameCheck !== null) {
            setIsAuthenticated(true);
        }

    })

    function registerHandler() {
        history('/register');
    }

    function signInHandler() {
        history('/login')
    }

    function logout() {
        authService.logout(usernameCheck);
        history('/')
    }

    let userNavigation = (

        <div className='userNavigation'>

            <Link to="/home"><span id='logo-header'>Crypto World</span></Link>

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

            <button onClick={registerHandler} type='submit' id='navigation-button-create'>Create Account</button>

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