import './UserDetails.css'


const UserDetails = () => {


    const currentUsername = JSON.parse(localStorage.getItem("usernameLogin"))


    return(
        <div className='user-info' id='user-details-welcome'>

            <span>Welcome </span>


        </div>
    );

}


export default UserDetails;