import { useState } from 'react';
import { useNavigate } from "react-router-dom";
import './Login.css'



const Login = () => {

    const onLoginFormSubmitHandler = (e) => {
        e.preventDefault();

        const username = e.target.username.value;
        const password = e.target.password.value;

        console.log(username, password);

    };

    return (


        <form id='login-form' onSubmit={onLoginFormSubmitHandler}>
            <p htmlFor="name">Sign In</p>


            <label htmlFor="username" >Username</label>
            <input name='username' placeholder='Username' type="text" id='text1' />


            <label htmlFor="password">Password</label>
            <input name='password' placeholder='Password' type="password" id='text4' />

            <button className="button" type="submit">Sign In</button>
        </form>


    );
}


export default Login;