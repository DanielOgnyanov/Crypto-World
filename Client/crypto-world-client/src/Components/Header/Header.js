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

               <span href="#">Sign In</span>


               </div>
            </div>
              





            </nav>


        </header>
    );
}

export default Header;