import { useAuthContext } from '../../../Context/AuthContext';
import './UserDetails.css'


const UserDetails = () => {


    const { user } = useAuthContext();


    return(
        <div className='user-info' id='user-details-welcome'>

            <span>Welcome {user.username}</span>


        </div>
    );

}


export default UserDetails;