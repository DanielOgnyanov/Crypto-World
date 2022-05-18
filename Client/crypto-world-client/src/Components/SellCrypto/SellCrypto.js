const SellCrypto = () => {

    const cryptoEnum = Object.freeze([

        { name: 'Bitcoin' },
        { name: 'Ethereum' },
        { name: 'Binance' },
        { name: 'Cardano' },
        { name: 'Tether' },
        { name: 'SOL' },
        { name: 'Ripple' },
        { name: 'Dotcoin' },
        { name: 'DogeCoin' },
        { name: 'USDC' }
    ]);







    return (

       <form>
           <label htmlFor='username-confirm'>Username Confirm</label>

           <input name='username-confirm' autoComplete="on" placeholder='Username Confirm'
                type="text" id='username-confirm' />










       </form>



    );
}


export default SellCrypto;