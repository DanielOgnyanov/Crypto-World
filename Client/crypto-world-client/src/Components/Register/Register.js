import './Register.css'
import { useHistory } from 'react-router-dom' ;




const Register = () => {

    
    

    return (

        <form  method="post">
 <ul>
  <li>
    <label for="name">Name:</label>
    
  </li>
  <li>
    <label for="mail">E-mail:</label>
   
  </li>
  <li>
    <label for="msg">Message:</label>
    <textarea id="msg" name="user_message"></textarea>
  </li>
 </ul>
</form>



    );
}

export default Register;