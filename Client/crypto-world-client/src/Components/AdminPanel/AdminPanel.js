import ChangeUserRole from '../AdminPanel/ChangeUserRole/ChangeUserRole'
import LoggedUsers from '../AdminPanel/LoggedUsersInfo/LoggedUsers'
import TopFiveCryptoBuy from '../AdminPanel/TopFiveCryptoBuy/TopFiveCryptoBuy'
import './AdminPanel.css'

const AdminPanel = () => {







    return (

        <>
            <div className='container-admin-panel' id='container-admin-panel'>

                <section className='change-user-role' id='change-user-role'>
                    <ChangeUserRole />

                </section>
                
                <section className='user-top-five-buy' id='user-top-five-buy'>
                    <TopFiveCryptoBuy />
                </section>

            </div>


            <div className='logged-users' id='logged-users'>
                <LoggedUsers />
            </div>

        </>


    );
}


export default AdminPanel;