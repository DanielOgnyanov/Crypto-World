import './Header.css'
import logoImg from "../../Images/logo-nav-1.png"
import { Link } from 'react-router-dom'
import { useNavigate } from "react-router-dom";


const Header = () => {

    const history = useNavigate();
    
    function handleClick ()  {
    
        history('/register');
    }

    

   

    return (
        
        <header>
            <nav className="topnav">
           <a href='/'><img src={logoImg} alt=""></img></a> 
                


               <div className='userNavigation'>
               <a href="#">Admin</a>
               <a href="#">Add Credit Card</a>
               <a href="#">Buy Crypto</a>
               <a href="#">Sell Crypto</a>
               </div>

               <div className='guestNavigation'>

               <a href="#">Sign In</a>
            
               <button  onClick={handleClick} type='submit'>Create Account</button>


               </div>
            
              





            </nav>


        </header>
    );
}

export default Header;