import * as authService from '../../Services/AuthService'
import { useNavigate } from "react-router-dom";
import { useAuthContext } from '../../Context/AuthContext';
import React, { useState } from 'react'
import './Login.css'



const Login = () => {

    const { login } = useAuthContext();
    const history = useNavigate();

    const [user, setUser] = useState("");
    const [password, setPassword] = useState("");


    const [inputUsernameError, setInputUsernameError] = useState(false);
    const [inputPasswordError, setInputPasswordError] = useState(false);
    const [wrongCredentialsError, setWrongCredentialsError] = useState(false);





    function userHandler(e) {

        let item = e.target.value.trim();


        if (item.length === 0) {

            setInputUsernameError(true);

        } else {
            
            setInputUsernameError(false);
        }

        setUser(item);

    }


    function passwordHandler(e) {

        let item = e.target.value.trim();

        if (item.length === 0) {

            setInputPasswordError(true);

        } else {

            setInputPasswordError(false);
        }


        setPassword(item);
    }



    const onLoginFormSubmitHandler = (e) => {
        e.preventDefault();

        authService
            .login(user, password);

            const usernameGet = JSON.parse(localStorage.getItem("username"));

            if(usernameGet === null){
                
            }


    };





    return (


        <>
            <form id='login-form' onSubmit={onLoginFormSubmitHandler}>
                <p htmlFor="name" id='login-p'>Sign In</p>


                <label htmlFor="username" id='login-label'>Username</label>
                <input name='username' autoComplete="on" placeholder='Username' type="text" id='login-username-input' onChange={userHandler} />
                {inputUsernameError ? <span id='span-info' >Input cannot be empty</span> : ""}

                <label htmlFor="password" id='login-label'>Password</label>
                <input name='password' autoComplete="on" placeholder='Password' type="password" id='login-password-input' onChange={passwordHandler} />
                {inputPasswordError ? <span id='span-info' >Input cannot be empty</span> : ""}
                {wrongCredentialsError ? <span id='span-info' >Wrong Username or Password !</span> : ""}

                <button disabled={inputUsernameError || inputPasswordError || password.length === 0 || user.length === 0} className="button" type="submit" id='login-button'>Sign In</button>
            </form>
        </>

    );
}


export default Login;