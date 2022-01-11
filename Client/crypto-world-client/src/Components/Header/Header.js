import './Header.css'
import { Link } from 'react-router-dom'
import { useNavigate } from "react-router-dom";


const Header = () => {
    const history = useNavigate();
    const navigateTo = () => history.push('/register');

    return (
        <header>
            <nav>

           
             
            <div class="topnav">
                   <div class="logo-image">
                      <img src="" class="img-fluid"/>
                   </div>
               <p>Crypto World</p>
               <div className='userNavigation'>
               <a href="#">Admin</a>
               <a href="#">Add Credit Card</a>
               <a href="#">Buy Crypto</a>
               <a href="#">Sell Crypto</a>
               </div>

               <div className='guestNavigation'>

               <a href="#">Sign In</a>
               <button onClick={navigateTo} type='button'>Create Account</button>


               </div>
            </div>
              





            </nav>


        </header>
    );
}

export default Header;