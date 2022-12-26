import './GetStarted.css'
import { Link } from 'react-router-dom'
import IndexPageBg from '../IndexPageBg/IndexPageBg';



const GetStarted = () => {




    return (


        <div id='container'>
            
        <div className='getStarted' id='getStarted-div'>
             
            <h1>Buy Bitcoin & Crypto Asset</h1>

            <p>Sign up today and
                <strong> buy top 10 cryptocurrencies</strong> ,
                <br />
                easly and fast. Get started with as little as
                <strong> $10.</strong>

            </p>
            <div className='getStartedButton' id='getStartedButton-div'>

                <Link className='button' to="/register">Get Started</Link>
            </div>



        </div>
        <IndexPageBg/>
        </div>


    );
}


export default GetStarted;