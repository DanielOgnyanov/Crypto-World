import './LoggedUsers.css';
import { FaUserCheck } from 'react-icons/fa';

const LoggedUsers = () => {
    return (
        <div id="form-logged-user-admin-panel">
            <FaUserCheck id="logged-user-icon" />
            <p id="p-logged-users">Total Logged-In Users: <span id="logged-user-count">0</span></p>
        </div>
    );
}

export default LoggedUsers;
