import ChangeUserRole from '../AdminPanel/ChangeUserRole/ChangeUserRole'
import LoggedUsers from '../AdminPanel/LoggedUsersInfo/LoggedUsers'
import TopFiveCryptoBuy from '../AdminPanel/TopFiveCryptoBuy/TopFiveCryptoBuy'
import './AdminPanel.css'

const AdminPanel = () => {







    return (

        <div className='container' id='container'>

            <div className='change-user-role' id='change-user-role'>
                <ChangeUserRole />

            </div>

            <div className='logged-users' id='logged-users'>
                <LoggedUsers />
            </div>

            <div className='user-top-five-buy'>
                <TopFiveCryptoBuy/>
            </div>


        </div>





    );
}


export default AdminPanel;