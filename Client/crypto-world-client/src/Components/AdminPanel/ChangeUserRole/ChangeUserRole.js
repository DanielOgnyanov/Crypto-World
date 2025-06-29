import { useState } from 'react';
import { changeUserRole } from '../../../Services/AuthService'; 
import './ChangeUserRole.css';

const ChangeUserRole = () => {
    const [username, setUsername] = useState('');
    const [roleName, setRoleName] = useState('ADMIN');

    const roleEnum = Object.freeze([
        { name: 'ADMIN' },
        { name: 'USER' }
    ]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const result = await changeUserRole(username, roleName);
            alert(result);
        } catch (error) {
            console.error(error);
            alert('Failed to change role: ' + error.message);
        }
    };

    return (
        <form id="form-change-user-role" onSubmit={handleSubmit}>
            <p id='p-change-role'>Change Role</p>

            <label id='admin-labels'>Username</label>
            <input
                name='username'
                autoComplete="on"
                placeholder='Username'
                type="text"
                id='username-change-role'
                value={username}
                onChange={(e) => setUsername(e.target.value)}
            />

            <label id='admin-labels'>Role Select</label>
            <select
                id='role-select'
                value={roleName}
                onChange={(e) => setRoleName(e.target.value)}
            >
                {roleEnum.map(role => (
                    <option key={role.name} value={role.name}>
                        {role.name}
                    </option>
                ))}
            </select>

            <button className="button" type="submit" id="button-change-user-role">
                Change Role
            </button>
        </form>
    );
};

export default ChangeUserRole;
