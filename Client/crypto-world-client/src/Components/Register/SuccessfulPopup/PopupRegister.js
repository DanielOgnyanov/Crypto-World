import Popup from 'reactjs-popup';
import './PopupRegister.css'

export const PopupRegister = () => {


    return(
        <div id='popup'>

            <div id='popup-inner'>

                <div id='check-mark-div'> 
                <span id='span-tick'>&#10004;</span>
                <h3 id='h3-success'>Success</h3>
                </div>

                <h4 id='h4-info-text'>Congratulations, your account has been successfully created.</h4>

                <button id='continue-button'>Continue</button>

            

            </div>
            

        </div>
    )
};