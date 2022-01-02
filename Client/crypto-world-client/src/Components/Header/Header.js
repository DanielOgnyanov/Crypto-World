import './navigation.css'
import { Link } from 'react-router-dom';


const Header = () => {

    let guestNavigation = (
        <div id="guest">
            <Link className="button" to="/login">Sign In</Link>
            <Link to="/register" className="button">Create Account</Link>
        </div>
    );



    return (
        <header id="site-header">
             <nav className="navbar">

             
       
             </nav>


        </header>
        

    );
}

export default Header;