import { useAuthContext } from '../../../Context/AuthContext';
import * as authService from '../../../Services/AuthService';
import './UserDetails.css';

const UserDetails = () => {
  const currentUser = authService.getUser();

  return (
    <div className="user-details-container">
      <p className="welcome-message">👋 Welcome back, <span className="username">{currentUser}</span>!</p>
    </div>
  );
};

export default UserDetails;
