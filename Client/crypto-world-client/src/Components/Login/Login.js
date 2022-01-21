import { useState } from 'react';
import { useNavigate } from "react-router-dom";
import './Login.css'



const Login = () => {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const history = useNavigate();



    function login() {

        history('/home');
        console.log(username);
    }

    return (


        <form id='login-form'>
            <p htmlFor="name">Sign In</p>


            <label htmlFor="username" >Username</label>
            <input name='username' placeholder='Username' type="text" id='text1'
                onChange={(e) => setUsername(e.target.value)} />


            <label htmlFor="password">Password</label>
            <input name='password' placeholder='Password' type="password" id='text4'
                onChange={(e) => setPassword(e.target.value)} />

            <button onClick={login}>Sign In</button>
        </form>


    );
}


export default Login;