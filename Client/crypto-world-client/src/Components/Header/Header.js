import './navigation.css'
import { Link } from 'react-router-dom';


const Header = () => {

    let guestNavigation = (
        <div id="guest">
            <Link to="/login"    className="button">Sign In</Link>
            <Link to="/register" className="button">Create Account</Link>
        </div>
    );


    let userNavigation = (
        <div id="user">
            <span>Welcome, Ivan </span>
            <Link className="button" to="/">Home</Link>
            <Link className="button" to="/create">Add Credit Card</Link>
            <Link className="button" to="/logout">Logout</Link>
        </div>
    );

    return (
        <header id="site-header">
             <nav className="navbar">

             <section className="navbar-dashboard">
             
                         userNavigation
                         guestNavigation
                    
             
             </section>
             
       
             </nav>


        </header>
        

    );
}

export default Header;