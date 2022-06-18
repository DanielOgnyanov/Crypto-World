const ChangeUserRole = () => {


    const roleEnum = Object.freeze([
        
        { name: 'ADMIN' },
        { name: 'USER' }
    ]);




    return (

       <form>
        <label htmlFor="Username" >Username</label>
        <input name='username' autoComplete="on" placeholder='Username' type="text" id='login-username' />



        <select className='user-role' >
                {roleEnum.map(role => (
                    <option >{role.name}</option>

                ))}


            </select>



            <button className="button" type="submit" >Change Role</button>










       </form>
        


    );
}

export default ChangeUserRole;