const ChangeUserRole = () => {


    const roleEnum = Object.freeze([
        
        { name: 'ADMIN' },
        { name: 'USER' }
    ]);




    return (

       <form>
        <label htmlFor="Username" >Username</label>
        <input name='username' autoComplete="on" placeholder='Username' type="text" id='login-username' />










       </form>
        


    );
}

export default ChangeUserRole;