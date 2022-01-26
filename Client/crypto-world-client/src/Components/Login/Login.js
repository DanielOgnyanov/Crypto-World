import { useState, useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import './Login.css'



const Login = () => {

    const history = useNavigate();

    const onLoginFormSubmitHandler = (e) => {
        e.preventDefault();

        const username = e.target.username.value;
        const password = e.target.password.value;

        


        let item = { username, password }


        let result = fetch("http://localhost:5000/users?username_like=" + username)
            .then((response) => {

                if(response.ok) {
                    
                } else {

                    
                }
            })
            .then((data) => console.log(data))

            console.log(result)
            


        

        





    };

    return (


        <form id='login-form' onSubmit={onLoginFormSubmitHandler}>
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