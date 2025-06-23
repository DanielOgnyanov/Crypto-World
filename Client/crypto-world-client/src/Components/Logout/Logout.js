import * as authService from '../../Services/AuthService';
import { useAuthContext } from '../../Context/AuthContext';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const Logout = () => {
  const { user, logout } = useAuthContext();
  const navigate = useNavigate();

  useEffect(() => {
    async function performLogout() {
      try {
        if (user?.username) {
          await authService.logout(user.username);
        }
        logout();           // Clear user in context
      } catch (error) {
        console.error("Logout error:", error);
      } finally {
        navigate('/');      // Redirect to index page no matter what
      }
    }

    performLogout();
  }, [user, logout, navigate]);

  return null; // or a loading spinner/message if you want
};

export default Logout;
