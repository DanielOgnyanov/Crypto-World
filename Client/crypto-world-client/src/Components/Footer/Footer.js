import './Footer.css'


const Footer = () => {
    return (
        <footer >
            
           <ul class="list-inline">
                <li class="list-inline-item"><a href="#">Home</a></li>
                <li class="list-inline-item"><a href="#">Services</a></li>
                <li class="list-inline-item"><a href="#">About</a></li>
                <li class="list-inline-item"><a href="#">Terms</a></li>
                <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
            </ul>
            <p class="copyright">&copy;Copyright 2021 Crypto World, Inc.</p>
        </footer>
    );
};

export default Footer;