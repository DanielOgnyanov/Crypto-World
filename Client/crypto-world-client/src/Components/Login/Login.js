import './Login.css'



const Login = () => {




    return (


        <form>
            <p for="name">Sign In</p>


            <label for="username" >Username</label>
            <input name='username' placeholder='Username' type="text" id='text1'></input>


            <label for="password">Password</label>
            <input name='password' placeholder='Password' type="password" id='text4'></input>

            <button>Create</button>
        </form>


    );
}


export default Login;