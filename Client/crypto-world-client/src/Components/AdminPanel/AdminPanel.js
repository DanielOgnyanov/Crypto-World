import ChangeUserRole from '../AdminPanel/ChangeUserRole/ChangeUserRole';
import LoggedUsers from '../AdminPanel/LoggedUsersInfo/LoggedUsers';
import './AdminPanel.css';

const AdminPanel = () => {
  return (
    <div className="admin-panel-container">
      <section className="admin-section">
        <ChangeUserRole />
      </section>

      <section className="admin-section">
        <LoggedUsers />
      </section>
    </div>
  );
};

export default AdminPanel;
