import { useState } from 'react';
import Popup from 'reactjs-popup';
import './PopupRegister.css'
import { useNavigate } from 'react-router-dom';


const PopupRegister = (e) => {

    const history = useNavigate();


    const [open, setOpen] = useState(true);
    const closePopup = () => (
        setOpen(false),
        history("/login")
    );

    return (open) ? (

        <div className='popup' id='popup'>

            <div className='popup-inner' id='popup-inner'>

                <div className='check-mark-div' id='check-mark-div'>
                    <span id='span-tick'>&#10004;</span>
                    <h3 id='h3-success'>Success</h3>
                </div>

                <h4 className='h4-info-text' id='h4-info-text'>Congratulations, your account has been successfully created.</h4>

                <button className='continue-button' id='continue-button' onClick={closePopup}>Continue</button>

            </div>
        </div>

    ) : ""
};

export default PopupRegister;