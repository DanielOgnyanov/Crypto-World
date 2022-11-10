import * as authService from '../../Services/authService'
import { useNavigate } from "react-router-dom";
import { useAuthContext } from '../../Context/AuthContext';
import React, { useState } from 'react'
import './Login.css'



const Login = () => {

    const { login } = useAuthContext();
    const history = useNavigate();

    const [user, setUser] = useState("");
    const [pass, setPass] = useState("");

    const [userError, setUserError] = useState(false);
    const [passError, setPassError] = useState(false);

    function userHandler(e) {

        let item = e.target.value;

        

        if (item.length < 3) {
            console.log(item)
            setUserError(true);

        } else {
            setUserError(false);
        }

    }




    const onLoginFormSubmitHandler = (e) => {
        e.preventDefault();





        let formData = new FormData(e.currentTarget);

        let username = formData.get('username');
        let password = formData.get('password');


        authService
            .login(username, password)
            .then((authData) => {

                login(authData);



                history('/home')
            })
            .catch(error => {

                console.log(error);

            })

    };

    return (


        <form id='login-form'  >
            <p htmlFor="name">Sign In</p>


            <label htmlFor="username" >Username</label>
            <input name='username' autoComplete="on" placeholder='Username' type="text" id='login-username' onChange={userHandler} />
            {userError ? <span>Username lenght need to be between 3 and 20 symbols</span> : ""}

            <label htmlFor="password">Password</label>
            <input name='password' autoComplete="on" placeholder='Password' type="password" id='login-password' />

            <button className="button" type="submit">Sign In</button>
        </form>


    );
}


export default Login;