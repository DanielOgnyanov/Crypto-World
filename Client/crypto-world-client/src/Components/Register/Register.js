import './Register.css'





const Register = () => {




  return (


    <form>
      <p for="name">Create Account</p>
      <div >
      <span className='icon'><i className='fa fa-user icon'></i></span>
      <label for="username" >Username</label>
      <input name='username' placeholder='Username' type="text"></input>
      
      </div>
      
      <label for="fullname">Full Name</label>
      <input name='fullname' placeholder='Full Name' type="text"></input>
      
      <label for="email">Email</label>
      <input name='email' placeholder='Email' type="text"></input>
      
      <label for="password">Password</label>
      <input name='password' placeholder='Password' type="password"></input>
      
      <label for="confirmPassword">Confirm Password</label>
      <input name='confirmPassword' placeholder='Confirm Password' type="password"></input>
    </form>


  );
}

export default Register;