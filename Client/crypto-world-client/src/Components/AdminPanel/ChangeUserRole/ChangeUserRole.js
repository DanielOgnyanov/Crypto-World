import './ChangeUserRole.css'


const ChangeUserRole = () => {


    const roleEnum = Object.freeze([

        { name: 'ADMIN' },
        { name: 'USER' }
    ]);




    return (

        <form id="form-change-user-role">

            <label  id='admin-labels'>Username</label>
            <input name='username' autoComplete="on" placeholder='Username' type="text" id='username-change-role' />







            <label id='admin-labels'>Role Select</label>

            <select htmlFor='role-select' id='role-select' >
                {roleEnum.map(role => (
                    <option >{role.name}</option>

                ))}


            </select>



            <button className="button" type="submit" id="button-change-user-role">Change Role</button>

        </form>



    );
}

export default ChangeUserRole;