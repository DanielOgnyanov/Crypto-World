import * as authService from '../../../Services/AuthService';
import './UserDetails.css';

const UserDetails = () => {
  const currentUser = authService.getUser();

 
  if (!currentUser) {
    
    return <p className="welcome-message">User data missing. Please login again.</p>;
  }

  return (
    <div className="user-details-container">
      <p className="welcome-message">
        👋 Welcome back, <span className="username">{currentUser.username}</span>!
      </p>
    </div>
  );
};

export default UserDetails;
