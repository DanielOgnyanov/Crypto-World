import * as authService from '../../Services/AuthService';
import { useNavigate } from "react-router-dom";
import { useAuthContext } from '../../Context/AuthContext';
import React, { useState } from 'react';
import './Login.css';

const Login = () => {
  const navigate = useNavigate();
  const { login } = useAuthContext();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [inputUsernameError, setInputUsernameError] = useState(false);
  const [inputPasswordError, setInputPasswordError] = useState(false);
  const [wrongCredentialsError, setWrongCredentialsError] = useState(false);

  const userHandler = (e) => {
    const item = e.target.value.trim();
    setUsername(item);
    setInputUsernameError(item.length === 0);
    setWrongCredentialsError(false); // reset error when user types
  };

  const passwordHandler = (e) => {
    const item = e.target.value.trim();
    setPassword(item);
    setInputPasswordError(item.length === 0);
    setWrongCredentialsError(false); // reset error when user types
  };

  const onLoginFormSubmitHandler = async (e) => {
    e.preventDefault();

    // Basic validation before sending login request
    if (inputUsernameError || inputPasswordError || !username || !password) {
      return;
    }

    try {
      // Attempt login
      const loggedInUser = await authService.login(username, password);

      // Set user in context (make sure your login() does this)
      login(loggedInUser);

      // Redirect after successful login
      navigate("/home");

    } catch (error) {
      // Show error message on failed login
      setWrongCredentialsError(true);
      console.error("Login failed:", error);
    }
  };

  return (
    <>
      <form id="login-form" onSubmit={onLoginFormSubmitHandler}>
        <p id="login-p">Sign In</p>

        <label htmlFor="username" id="login-label">Username</label>
        <input
          name="username"
          autoComplete="on"
          placeholder="Username"
          type="text"
          id="login-username-input"
          onChange={userHandler}
          value={username}
        />
        {inputUsernameError && <span id="span-info">Input cannot be empty</span>}

        <label htmlFor="password" id="login-label">Password</label>
        <input
          name="password"
          autoComplete="on"
          placeholder="Password"
          type="password"
          id="login-password-input"
          onChange={passwordHandler}
          value={password}
        />
        {inputPasswordError && <span id="span-info">Input cannot be empty</span>}

        {wrongCredentialsError && <span id="span-info">Wrong Username or Password!</span>}

        <button
          disabled={
            inputUsernameError ||
            inputPasswordError ||
            password.length === 0 ||
            username.length === 0
          }
          className="button"
          type="submit"
          id="login-button"
        >
          Sign In
        </button>
      </form>
    </>
  );
};

export default Login;
