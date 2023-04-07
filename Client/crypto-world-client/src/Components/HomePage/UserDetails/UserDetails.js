import { useAuthContext } from '../../../Context/AuthContext';
import * as authService from '../../../Services/AuthService';
import './UserDetails.css'


const UserDetails = () => {


    const currentUser =  authService.getUser();

    return(
        <div className='user-info' id='user-details-welcome'>

            <span>Welcome {currentUser}</span>


        </div>
    );

}


export default UserDetails;