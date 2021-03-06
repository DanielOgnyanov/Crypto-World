import './Header.css'
import logoImg from "../../Images/logo-nav-2.png"
import { Link } from 'react-router-dom'
import { useNavigate } from "react-router-dom";
import { useAuthContext } from '../../Context/AuthContext';


const Header = () => {

    const { user } = useAuthContext();

    const history = useNavigate();


    function handleClick() {

        history('/register');
    }

    let userNavigation = (

        <div className='userNavigation'>

            <Link className='button' to="/home" data-toggle="collapse">Home</Link>
            <Link className='button' to="#" data-toggle="collapse">Admin</Link>

            <Link className='button' to="/add-credit-card">Add Credit Card</Link>
            <Link className='button' to="#">Buy Crypto</Link>
            <Link className='button' to="#">Sell Crypto</Link>

        </div>

    );


    let guestNavigation = (

        <div className='guestNavigation'>

            <Link className='button' to="/login">Sign In</Link>

            <button onClick={handleClick} type='submit'>Create Account</button>


        </div>
    );


    return (

        <header>
            <nav className="topnav">
                <Link className='button' to="/" ><img src={logoImg} alt=""></img></Link>

                <div className='userNavigation'>

                    <Link className='button' to="/home" data-toggle="collapse">Home</Link>
                    <Link className='button' to="/admin" data-toggle="collapse">Admin</Link>

                    <Link className='button' to="/add-credit-card">Add Credit Card</Link>
                    <Link className='button' to="/buy-crypto">Buy Crypto</Link>
                    <Link className='button' to="sell-crypto">Sell Crypto</Link>
                    

                </div>

                <div className='guestNavigation'>

                    <Link className='button' to="/login">Sign In</Link>

                    <button onClick={handleClick} type='submit'>Create Account</button>


                </div>

            </nav>


        </header>
    );
}

export default Header;