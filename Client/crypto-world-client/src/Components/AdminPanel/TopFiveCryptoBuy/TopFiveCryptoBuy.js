import './TopFiveCryptoBuy.css'



const LastBuy = () => {









    return (

        <form>
            <p>Top 5 Crypto Buy</p>

            <label htmlFor="Username" >Username</label>
            <input name='username' autoComplete="on" placeholder='Username' type="text" />

            <button className="button" type="submit" id="button-find-user-last-five-buy">Change Role</button>


        </form>



    );
}


export default LastBuy;