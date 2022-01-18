import './Header.css'
import logoImg from "../../Images/logo-nav-2.png"
import { Link } from 'react-router-dom'
import { useNavigate } from "react-router-dom";


const Header = () => {

    const history = useNavigate();

    function handleClick() {

        history('/register');
    }





    return (

        <header>
            <nav className="topnav">
                <Link className='button' to="/" ><img src={logoImg} alt=""></img></Link>



                <div className='userNavigation'>

                
                    <Link className='button' to="#" data-toggle="collapse">Admin</Link>

                    <Link className='button' to="#">Add Credit Card</Link>
                    <Link className='button' to="#">Buy Crypto</Link>
                    <Link className='button' to="#">Sell Crypto</Link>

                </div>

                <div className='guestNavigation'>

                    <Link className='button' to="#">Sign In</Link>

                    <button onClick={handleClick} type='submit'>Create Account</button>


                </div>







            </nav>


        </header>
    );
}

export default Header;