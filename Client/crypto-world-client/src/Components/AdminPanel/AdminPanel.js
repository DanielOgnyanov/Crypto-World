import ChangeUserRole from '../AdminPanel/ChangeUserRole/ChangeUserRole'
import LoggedUsers from '../AdminPanel/LoggedUsersInfo/LoggedUsers'

const AdminPanel = () => {







    return (

        <div className='container' id='container '>

            <div className='change-user-role'>
                <ChangeUserRole />

            </div>

            <div className='logged-users' id='logged-users'>
                <LoggedUsers />
            </div>


        </div>





    );
}


export default AdminPanel;