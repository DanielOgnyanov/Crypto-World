import { useState } from 'react';
import Popup from 'reactjs-popup';
import './PopupRegister.css'

export const PopupRegister = (e) => {


    const [open, setOpen] = useState(true);
    const closePopup =()=>(
        setOpen(false)
    )

    
    

    return (e.redirect) ?  (

        
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