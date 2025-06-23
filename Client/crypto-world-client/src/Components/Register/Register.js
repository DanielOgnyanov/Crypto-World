import './SuccessfulPopup/PopupRegister.css';
import './Register.css';
import React, { useState } from 'react';
import * as userInfoService from '../../Services/UserInfoService';
import * as registerService from '../../Services/RegisterService';
import * as utils from '../../Utils/Utils';
import { useNavigate } from "react-router-dom";
import PopupRegister from '../Register/SuccessfulPopup/PopupRegister';

const Register = () => {

  const [redirect, setRedirect] = useState(false);

  // Validation states
  const [isUsernameIsCorrect, setIsUsernameIsCorrect] = useState(false);
  const [isEmailCorrect, setIsEmailCorrect] = useState(false);
  const [isFullNameCorrect, setIsFullNameCorrect] = useState(false);
  const [isCountryCorrect, setIsCountryCorrect] = useState(false);
  const [isPasswordCorrect, setIsPasswordCorrect] = useState(false);
  const [isInputIsCorrectConfirmPassword, setIsInputIsCorrectConfirmPassword] = useState(false);

  // Username and errors
  const [username, setUsername] = useState("");
  const [usernameError, setUsernameError] = useState(false);
  const [isTakenUsername, setIsTakenUsername] = useState(false);

  // Full name and error
  const [fullName, setFullname] = useState("");
  const [fullNameError, setFullNameError] = useState(false);

  // Email and errors
  const regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;
  const [email, setEmail] = useState("");
  const [emailError, setEmailError] = useState(false);
  const [emailIsFree, setEmailIsFree] = useState(true);

  // Country and error
  const [country, setCountry] = useState("");
  const [countryError, setCountryError] = useState(false);

  // Password and errors
  const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@#$%^&+=!?]).{5,}$/;
  const [password, setPass] = useState("");
  const [passError, setPassError] = useState(false);

  // Confirm password and errors
  const [confirmPassword, setConfirmPassword] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState(false);
  const [isPasswordMatch, setIsPasswordMatch] = useState(true);

  // Username validation and async uniqueness check
  async function usernameHandler(e) {
    const value = e.target.value.trim();
    setUsername(value);

    if (value.length < 3 || value.length > 20) {
      setUsernameError(true);
      setIsUsernameIsCorrect(false);
      setIsTakenUsername(false);
      return;
    } else {
      setUsernameError(false);

      try {
        await userInfoService.findIfUsernameIsTakenInDb(value);
        // If no error, username is taken
        setIsTakenUsername(true);
        setIsUsernameIsCorrect(false);
      } catch {
        // Error means username is free (assuming your service rejects if taken)
        setIsTakenUsername(false);
        setIsUsernameIsCorrect(true);
      }
    }
  }

  // Full name validation
  function fullNameHandler(e) {
    const value = e.target.value.trim();
    setFullname(value);

    if (value.length < 5 || value.length > 20) {
      setFullNameError(true);
      setIsFullNameCorrect(false);
    } else {
      setFullNameError(false);
      setIsFullNameCorrect(true);
    }
  }

  // Email validation and async uniqueness check
  async function emailHandler(e) {
    const value = e.target.value.trim();
    setEmail(value);

    if (!value.match(regex)) {
      setEmailError(true);
      setIsEmailCorrect(false);
      setEmailIsFree(true);
      return;
    } else {
      setEmailError(false);

      try {
        await userInfoService.checkIfTheEmailIsNotTaken(value);
        // If no error, email is free
        setEmailIsFree(true);
        setIsEmailCorrect(true);
      } catch {
        // Email taken
        setEmailIsFree(false);
        setIsEmailCorrect(false);
      }
    }
  }

  // Country selection validation
  function countryHandler(e) {
    const value = e.target.value;
    setCountry(value);

    if (!value || value === "Country") {
      setCountryError(true);
      setIsCountryCorrect(false);
    } else {
      setCountryError(false);
      setIsCountryCorrect(true);
    }
  }

  // Password validation
  function passwordHandler(e) {
    const value = e.target.value.trim();
    setPass(value);

    if (value.length < 5 || !value.match(passwordRegex)) {
      setPassError(true);
      setIsPasswordCorrect(false);
    } else {
      setPassError(false);
      setIsPasswordCorrect(true);
    }

    // Check confirm password match when password changes
    if (confirmPassword && value === confirmPassword) {
      setIsPasswordMatch(true);
      setIsInputIsCorrectConfirmPassword(true);
      setConfirmPasswordError(false);
    } else if (confirmPassword) {
      setIsPasswordMatch(false);
      setIsInputIsCorrectConfirmPassword(false);
    }
  }

  // Confirm password validation
  function confirmPassowrdHandler(e) {
    const value = e.target.value.trim();
    setConfirmPassword(value);

    if (value.length < 5 || !value.match(passwordRegex)) {
      setConfirmPasswordError(true);
      setIsInputIsCorrectConfirmPassword(false);
      setIsPasswordMatch(false);
      return;
    } else {
      setConfirmPasswordError(false);
    }

    if (value === password) {
      setIsPasswordMatch(true);
      setIsInputIsCorrectConfirmPassword(true);
    } else {
      setIsPasswordMatch(false);
      setIsInputIsCorrectConfirmPassword(false);
    }
  }

  // Form submit handler
  const onRegisterFormSubmitHandler = async (e) => {
    e.preventDefault();

    if (
      !isUsernameIsCorrect ||
      !isEmailCorrect ||
      !isFullNameCorrect ||
      !isPasswordCorrect ||
      !isInputIsCorrectConfirmPassword ||
      !isCountryCorrect
    ) {
      // You can optionally add a general error message here
      return;
    }

    try {
      await registerService.register(username, fullName, email, country, password, confirmPassword);
      setRedirect(true);
    } catch (error) {
      console.log(error);
      // Optional: set error state to show general error message to user
    }
  };

  return (
    <>
      <div className='popup-register'>
        {redirect && <PopupRegister />}
      </div>

      <form id='form-register' onSubmit={onRegisterFormSubmitHandler}>
        <p id='register-p'>Create Account</p>

        <label htmlFor="username" id='label-register'>Username</label>
        <input
          name='username'
          placeholder='Username'
          type="text"
          id='username-input'
          value={username}
          onChange={usernameHandler}
        />
        {usernameError && <span id='span-info-register'>Username length must be between 3 and 20 symbols.</span>}
        {isTakenUsername && <span id='span-info-register'>Username is used by another person.</span>}
        {!usernameError && !isTakenUsername && isUsernameIsCorrect && <span id='span-green-tick'>&#10004;</span>}

        <label htmlFor="fullname" id='label-register'>Full Name</label>
        <input
          name='fullname'
          placeholder='Full Name'
          type="text"
          id='fullname-input'
          value={fullName}
          onChange={fullNameHandler}
        />
        {fullNameError && <span id='span-info-register'>Full name length must be between 5 and 20 characters.</span>}
        {!fullNameError && isFullNameCorrect && <span id='span-green-tick'>&#10004;</span>}

        <label htmlFor="email" id='label-register'>Email</label>
        <input
          name='email'
          placeholder='Email'
          type="email"
          id='email-input'
          value={email}
          onChange={emailHandler}
        />
        {emailError && <span id='span-info-register'>Email is not valid.</span>}
        {!emailIsFree && <span id='span-info-register'>Email is used by another person.</span>}
        {!emailError && emailIsFree && isEmailCorrect && <span id='span-green-tick'>&#10004;</span>}

        <label htmlFor="country" id='label-register'>Country</label>
        <select
          id='select-country'
          value={country}
          onChange={countryHandler}
        >
          <option value="Country" disabled>Country</option>
          {utils.country.map(c => (
            <option key={c.name} value={c.name}>{c.name}</option>
          ))}
        </select>
        {countryError && <span id='span-info-register'>Please select your country.</span>}
        {!countryError && isCountryCorrect && <span id='span-green-tick'>&#10004;</span>}

        <label htmlFor="password" id='label-register'>Password</label>
        <input
          name='password'
          placeholder='Password'
          type="password"
          id='password-input'
          value={password}
          onChange={passwordHandler}
        />
        {passError && <span id='span-info-register'>Password must be at least 5 characters and contain letters, numbers, and special characters.</span>}
        {!passError && isPasswordCorrect && <span id='span-green-tick'>&#10004;</span>}

        <label htmlFor="confirmPassword" id='label-register'>Confirm Password</label>
        <input
          name='confirmPassword'
          placeholder='Confirm Password'
          type="password"
          id='password-input'
          value={confirmPassword}
          onChange={confirmPassowrdHandler}
        />
        {confirmPasswordError && <span id='span-info-register'>Confirm password must meet password requirements.</span>}
        {!isPasswordMatch && !confirmPasswordError && <span id='span-info-register'>Passwords do not match.</span>}
        {isPasswordMatch && !confirmPasswordError && isInputIsCorrectConfirmPassword && <span id='span-green-tick'>&#10004;</span>}

         <button type="submit" className="button" disabled={
          !isUsernameIsCorrect
          || !isEmailCorrect
          || !isFullNameCorrect
          || !isPasswordCorrect
          || !isInputIsCorrectConfirmPassword
          || !isCountryCorrect}
          id='register-form-button'>Register</button>
      </form>
    </>
  );
};

export default Register;
