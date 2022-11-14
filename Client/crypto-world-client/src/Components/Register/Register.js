import './Register.css'
import React, { useState } from 'react'
import * as userInfoService from '../../Services/UserInfoService'





const Register = () => {


  const [username, setUsername] = useState("");
  const [usernameError, setUsernameError] = useState("");

  const [isTakenUsername, setIsTakenUsername] = useState(false);


  const [fullName, setFullname] = useState("");
  const [fullNameError, setFullNameError] = useState(false);



  function usernameHandler(e) {

    let item = e.target.value.trim();

    if (item.length < 3 || item.length > 20) {

      setUsernameError(true);

    } else {

      setUsernameError(false);

      userInfoService.findIfUsernameIsTakenInDb(item).then((item) => {

        userInfoService.findIfUsernameIsTakenInDb(item);


        setIsTakenUsername(false);
      }).catch(error => {

        setIsTakenUsername(true);
        console.log(error);
      })
    }

    setUsername(item)
  }



  function fullNamehandler(e) {

    let item = e.target.value.trim();

    if (item.length < 5 || item.length > 20) {

      setFullNameError(true);
    } else {

      setFullNameError(false);

    }

    setFullname(item);

  }


  return (


    <form id='form-register'>
      <p htmlFor="name">Create Account</p>


      <label htmlFor="username" >Username</label>
      <input name='username' placeholder='Username' type="text" id='text1' onChange={usernameHandler}></input>

      {usernameError ? <span id='span-info-register'>Username lenght need to be between 3 and 20 symbols.</span> : ""}
      {isTakenUsername ? <span id='span-info-register'>Username is used by another person.</span> : ""}


      <label htmlFor="fullname">Full Name</label>
      <input name='fullname' placeholder='Full Name' type="text" id='text2' onChange={fullNamehandler}></input>
      {fullNameError ? <span id='span-info-register'>Full name length must be between 5 and 20 characters.</span> : ""}


      <label htmlFor="email">Email</label>
      <input name='email' placeholder='Email' type="email" id='text3'></input>

      <label htmlFor="password">Password</label>
      <input name='password' placeholder='Password' type="password" id='text4'></input>

      <label htmlFor="confirmPassword">Confirm Password</label>
      <input name='confirmPassword' placeholder='Confirm Password' type="password" id='text4'></input>

      <button>Create</button>
    </form>


  );
}

export default Register;