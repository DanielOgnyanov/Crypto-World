import * as authService from '../../Services/AuthService'
import { useNavigate } from "react-router-dom";
import { useAuthContext } from '../../Context/AuthContext';
import React, { useState } from 'react'
import './Login.css'



const Login = () => {

    const { login } = useAuthContext();
    const history = useNavigate();

    const [user, setUser] = useState("");
    const [passord, setPass] = useState("");

    
    const [inputError, setInputError] = useState(false);

    function userHandler(e) {

        let item = e.target.value.trim();

        console.log(item)

        if (item === "") {
            
            setInputError(true);

        } else {
            setInputError(false);
            
        }

        setUser(item);

    }


    function passwordHandler(e){

        let item = e.target.value.trim();

        if(item === ""){

            setInputError(true);

        } else {

            setInputError(false);

        }

        setPass(item);
    }




    const onLoginFormSubmitHandler = (e) => {
        e.preventDefault();


        authService
            .login(user, passord)
            .then((authData) => {

                login(authData);

                history('/home')
            })
            .catch(error => {

                console.log(error);

            })

    };

    return (


        <>
        <form id='login-form'  onSubmit={onLoginFormSubmitHandler}>
            <p htmlFor="name" id='login-p'>Sign In</p>


            <label htmlFor="username" id='login-label'>Username</label>
            <input name='username' autoComplete="on" placeholder='Username' type="text" id='login-username-input' onChange={userHandler} />
            

            <label htmlFor="password" id='login-label'>Password</label>
            <input name='password' autoComplete="on" placeholder='Password' type="password" id='login-password-input' onChange={passwordHandler}/>
            {inputError ? <span id='span-info' >Password lenght must be atleast 5 symbols</span> : ""}

            <button disabled={!inputError} className="button" type="submit" id='login-button'>Sign In</button>
        </form>
        </>

    );
}


export default Login;