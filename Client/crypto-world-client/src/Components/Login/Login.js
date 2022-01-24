import { useState, useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import './Login.css'



const Login = () => {

    const onLoginFormSubmitHandler = (e) => {
        e.preventDefault();

        const username = e.target.username.value;
        const password = e.target.password.value;

        

        function login () {


            let item = {username, password}

            
            console.log(item.username)


            let result =  fetch ("http://localhost:5000/users", {
                method: 'POST',
                body: JSON.stringify(item),
                headers: {

                    "Content-Type": 'application/json',
                    "Accept": 'application/json'

                }
            });

            result = result.json();
            console.warn("result", result);


        }     

    };

    return (


        <form  id='login-form' onSubmit={onLoginFormSubmitHandler}>
            <p htmlFor="name">Sign In</p>


            <label htmlFor="username" >Username</label>
            <input name='username' autoComplete="on" placeholder='Username' type="text" id='login-username' />


            <label htmlFor="password">Password</label>
            <input name='password' autoComplete="on" placeholder='Password' type="password" id='login-password' />

            <button className="button" type="submit">Sign In</button>
        </form>


    );
}


export default Login;