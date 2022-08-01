import ChangeUserRole from '../AdminPanel/ChangeUserRole/ChangeUserRole'
import LoggedUsers from '../AdminPanel/LoggedUsersInfo/LoggedUsers'

const AdminPanel = () => {







    return (

        <div className='container'>

            <div className='change-user-role'>
                <ChangeUserRole />

            </div>

            <div className='logged-users'>
                <LoggedUsers />
            </div>


        </div>





    );
}


export default AdminPanel;