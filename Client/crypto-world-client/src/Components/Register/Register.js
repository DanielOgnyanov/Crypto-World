import './Register.css'
import React, { useState } from 'react'





const Register = () => {


  const[username, setUsername] = useState("");
  const[usernameError, setUsernameError] = useState("");


  const [fullName, setFullname] = useState("");
  const [fullNameError, setFullNameError] = useState(false);



  function usernameHandle(e){


    
  }



  function fullNamehandler(e){

    let item = e.target.value.trim();

    if(item.length < 5 || item.length > 20){

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
      <input name='username' placeholder='Username' type="text" id='text1'></input>
      
      
      
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