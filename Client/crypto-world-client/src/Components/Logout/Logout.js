
import * as authService from '../../Services/AuthService'
import { useAuthContext } from '../../Context/AuthContext';
import { useEffect } from 'react';

const Logout = () => {
    
    const { user, logout } = useAuthContext();
    
    useEffect(() => {
        console.log(Boolean(authService.isAuthenticated))
        console.log("OK")
        authService.logout(user.username)
            .then(() => {
                logout();
                
            })
    }, [])

    return null;
};

export default Logout;