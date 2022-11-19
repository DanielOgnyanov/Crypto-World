import './Register.css'
import React, { useState } from 'react'
import * as userInfoService from '../../Services/UserInfoService'





const Register = () => {


  const [isUsernameIsCorrect, setIsUsernameIsCorrect] = useState(false);
  const [isEmailCorrect, setIsEmailCorrect] = useState(false);
  const [isFullNameCorrect , setIsFullNameCorrect] = useState(false);
  const [isPasswordCorrect, setIsPasswordCorrect] = useState(false);
  const [isInputIsCorrectConfirmPassword, setIsInputIsCorrectConfirmPassword] = useState(false);

  const [username, setUsername] = useState("");
  const [usernameError, setUsernameError] = useState("");
  const [isTakenUsername, setIsTakenUsername] = useState(false);


  const [fullName, setFullname] = useState("");
  const [fullNameError, setFullNameError] = useState(false);

  const regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;
  const [email, setEmail] = useState("");
  const [emailError, setEmailError] = useState(false);
  const [emailIsFree, setEmailIsFree] = useState(true);


  const passowrdRegex = /^(.*[A-z])(.*[0-9])([@#$%^&+=!?])$/;
  const [password, setPass] = useState("");
  const [passError, setPassError] = useState(false);

  const [confirmPassword, setConfirmPassword] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState(false);
  const [isPasswordMatch, setIsPasswordMatch] = useState(true);




  function usernameHandler(e) {

    let item = e.target.value.trim();

    if (item.length < 3 || item.length > 20) {

      setUsernameError(true);

    } else {

      setUsernameError(false);

      userInfoService.findIfUsernameIsTakenInDb(item).then((item) => {

        userInfoService.findIfUsernameIsTakenInDb(item);


        setIsTakenUsername(false);
        setIsUsernameIsCorrect(true);

      }).catch(error => {

        setIsTakenUsername(true);
        setIsUsernameIsCorrect(false);
        console.log(error);
      })
    }

    setUsername(item)
  }



  function fullNameHandler(e) {

    let item = e.target.value.trim();

    if (item.length < 5 || item.length > 20) {

      setFullNameError(true);
    } else {

      setFullNameError(false);
      setIsFullNameCorrect(true);

    }

    setFullname(item);

  }


  function emailHandler(e) {

    let item = e.target.value.trim();

    if (!item.match(regex)) {
      setEmailError(true);
    } else {
      setEmailError(false);

      userInfoService.checkIfTheEmailIsNotTaken(item).then((item) => {

        userInfoService.checkIfTheEmailIsNotTaken(item);

        setEmailIsFree(true);
        setIsEmailCorrect(true);
      }).catch(error => {

        setEmailIsFree(false);
        setIsEmailCorrect(false);
        console.log(error);
      })
    }

    setEmail(item);
  }

  function passwordHandler(e) {

    let item = e.target.value.trim();

    if (item.length < 5 || !item.match(passowrdRegex)) {

      setPassError(true);
      

    } else {

      setPassError(false);
      setIsPasswordCorrect(true);

    }

    setPass(item);

  }


  function confirmPassowrdHandler(e){

    let item = e.target.value.trim();

    if(item.length < 5 || !item.match(passowrdRegex)){

      setConfirmPasswordError(true);

    } else {

      setConfirmPasswordError(false);

    }

    


    if(item.match(password)){

      setIsPasswordMatch(true);
      setIsInputIsCorrectConfirmPassword(true);

    } else {

      setIsPasswordMatch(false);
      setIsInputIsCorrectConfirmPassword(false);
      
    }

    setConfirmPassword(item);

  }


  return (


    <form id='form-register'>
      <p htmlFor="name">Create Account</p>


      <label htmlFor="username" >Username</label>
      <input name='username' placeholder='Username' type="text" id='text1' onChange={usernameHandler}></input>

      {usernameError ? <span id='span-info-register'>Username lenght need to be between 3 and 20 symbols.</span> : ""}
      {isTakenUsername ? <span id='span-info-register'>Username is used by another person.</span> : ""}
      {!usernameError && !isTakenUsername && isUsernameIsCorrect ? <span id='span-green-tick'>&#10004;</span> : ""}

      <label htmlFor="fullname">Full Name</label>
      <input name='fullname' placeholder='Full Name' type="text" id='text2' onChange={fullNameHandler}></input>
      {fullNameError ? <span id='span-info-register'>Full name length must be between 5 and 20 characters.</span> : ""}
      {!fullNameError && isFullNameCorrect ? <span id='span-green-tick'>&#10004;</span> : ""}

      <label htmlFor="email">Email</label>
      <input name='email' placeholder='Email' type="email" id='text3' onChange={emailHandler}></input>
      {emailError ? <span id='span-info-register'>Email is not valid.</span> : ""}
      {emailIsFree ? "" : <span id='span-info-register'>Email is used by another person.</span>}
      {!emailError && emailIsFree && isEmailCorrect ? <span id='span-green-tick'>&#10004;</span> : ""}



      <label htmlFor="password">Password</label>
      <input name='password' placeholder='Password' type="password" id='text4' onChange={passwordHandler}></input>
      {passError ? <span id='span-info-register' >Password lenght must be atleast 5 symbols and contains letters , numebrs and special symbols.</span> : ""}
      {!passError && isPasswordCorrect ? <span id='span-green-tick'>&#10004;</span> : ""}


      <label htmlFor="confirmPassword">Confirm Password</label>
      <input name='confirmPassword' placeholder='Confirm Password' type="password" id='text4' onChange={confirmPassowrdHandler}></input>
      {confirmPasswordError ? <span id='span-info-register'>Confirm Password lenght must be atleast 5 symbols and contains letters , numebrs and special symbols.</span> : ""}
      {isPasswordMatch ?  "" : <span id='span-info-register'>Password not match.</span> }
      {!confirmPasswordError && isInputIsCorrectConfirmPassword ? <span id='span-green-tick'>&#10004;</span> : "" }


      <button disabled = {
        isUsernameIsCorrect 
        && isEmailCorrect 
        && isFullNameCorrect 
        && isPasswordCorrect 
        && isInputIsCorrectConfirmPassword}
       id='register-form-button'>Register</button>
    </form>


  );
}

export default Register;