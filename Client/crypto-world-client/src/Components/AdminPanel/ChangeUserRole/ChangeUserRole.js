const ChangeUserRole = () => {


    const roleEnum = Object.freeze([

        { name: 'ADMIN' },
        { name: 'USER' }
    ]);




    return (

        <form id="form-change-user-role">
            <label htmlFor="Username" >Username</label>
            <input name='username' autoComplete="on" placeholder='Username' type="text" id='username-change-role' />



            <select className='select-role' >
                {roleEnum.map(role => (
                    <option >{role.name}</option>

                ))}


            </select>



            <button className="button" type="submit" id="button-change-user-role">Change Role</button>

        </form>



    );
}

export default ChangeUserRole;