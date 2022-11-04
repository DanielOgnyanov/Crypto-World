import './TopFiveCryptoBuy.css'



const TopFiveCryptoBuy = () => {

    const topFiveCrypto = [
        { id: 1, coinName: 'Bitcoin' },
        { id: 2, coinName: 'Ethereum' }

    ];









    return (

        <form id='form-top-five-crypto-buy'>



            <label htmlFor="Username" >Username</label>
            <input name='username' autoComplete="on" placeholder='Username' type="text" id='username-top-five-crypto' />

            <button className="button" type="submit" >Change Role</button>


            <p>Top 5 Crypto Buy</p>



        </form>



    );
}


export default TopFiveCryptoBuy;