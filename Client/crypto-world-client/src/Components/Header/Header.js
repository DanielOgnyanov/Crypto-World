import './header.css'
import { Link } from 'react-router-dom'
const Header = () => {



    return (
        <header>
            <nav>

           
             
            <div class="topnav">
               <a href="#home">Home</a>
               <a href="#news">Admin</a>
               <a href="#contact">Add Credit Card</a>
               <a href="#about">Buy Crypto</a>
               <a href="#about">Sell Crypto</a>
               <a className = "active"href="#about">Logout</a>
            </div>
              





            </nav>


        </header>
    );
}

export default Header;