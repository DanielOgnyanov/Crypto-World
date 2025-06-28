import './LoggedUsers.css';
import { FaUserCheck } from 'react-icons/fa';
import { useEffect, useState } from 'react';
import { fetchLoggedUserCount } from '../../../Services/AuthService';  

const LoggedUsers = () => {
    const [loggedUserCount, setLoggedUserCount] = useState(0);

    useEffect(() => {
        const getCount = async () => {
            const count = await fetchLoggedUserCount();
            setLoggedUserCount(count);
        };

        getCount();
    }, []);

    return (
        <div id="form-logged-user-admin-panel">
            <FaUserCheck id="logged-user-icon" />
            <p id="p-logged-users">
                Total Logged-In Users: <span id="logged-user-count">{loggedUserCount}</span>
            </p>
        </div>
    );
};

export default LoggedUsers;

