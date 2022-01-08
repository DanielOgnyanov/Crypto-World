import './header.css'
import { Link } from 'react-router-dom'
const Header = () => {



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
               <button href = "#">Create Account</button>


               </div>
            </div>
              





            </nav>


        </header>
    );
}

export default Header;