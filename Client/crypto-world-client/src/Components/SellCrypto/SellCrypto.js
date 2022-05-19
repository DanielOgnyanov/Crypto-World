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




            <label htmlFor='crypto-asset'>Crypto Asset</label>

            <select >
                {cryptoEnum.map(asset => (
                    <option id='crypto-asset-option'>{asset.name}</option>

                ))}


            </select>

            <button className="button" type="submit" >Sell Crypto</button>



        </form>



    );
}


export default SellCrypto;