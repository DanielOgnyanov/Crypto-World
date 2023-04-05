import { createContext, useContext } from 'react';
import useLocalStorage from '../Hooks/LocalStorage';


const initialAuthState = {
    username: ''
};

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useLocalStorage('user', initialAuthState);

    const loginData = (authData) => {
        setUser(authData);
    }

    const logoutData = () => {
        setUser(initialAuthState);
    };

    return (
        <AuthContext.Provider value={{ user, loginData, logoutData, isAuthenticated:  user.username }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuthContext = () => {
    const authState = useContext(AuthContext);

    return authState;
}