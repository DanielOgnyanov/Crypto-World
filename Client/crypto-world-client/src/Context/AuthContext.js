import { createContext, useContext } from 'react';
import useLocalStorage from '../Hooks/LocalStorage';


const initialAuthState = {
    usernameLogin: ''
};

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useLocalStorage('usernameLogin', initialAuthState);

    const loginData = (authData) => {
        setUser(authData);
    }

    const logout = () => {
        setUser(initialAuthState);
    };

    return (
        <AuthContext.Provider value={{ user, loginData, logout, isAuthenticated:  user.username }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuthContext = () => {
    const authState = useContext(AuthContext);

    return authState;
}