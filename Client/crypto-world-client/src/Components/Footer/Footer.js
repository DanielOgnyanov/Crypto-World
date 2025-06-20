import './Footer.css';
import { Link } from 'react-router-dom';

const Footer = () => {
    return (
        <footer>
            <p>cryptoworld.com</p>
            <ul>
                
                <li><Link to="/services">Services</Link></li>
                
                <li><Link to="/terms">Terms</Link></li>
                <li><Link to="/privacy">Privacy Policy</Link></li>
            </ul>
            <span>&copy; {new Date().getFullYear()} Crypto World, Inc.</span>
        </footer>
    );
};

export default Footer;
