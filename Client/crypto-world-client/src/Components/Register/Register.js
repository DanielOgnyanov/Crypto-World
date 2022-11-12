import './Register.css'
import React, { useState } from 'react'





const Register = () => {

  const [fullName, setFullname] = useState("");



  function fullNamehandler(e){

  }




  return (


    <form>
      <p htmlFor="name">Create Account</p>
      
      
      <label htmlFor="username" >Username</label>
      <input name='username' placeholder='Username' type="text" id='text1'></input>
      
      
      
      <label htmlFor="fullname">Full Name</label>
      <input name='fullname' placeholder='Full Name' type="text" id='text2'></input>
      
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