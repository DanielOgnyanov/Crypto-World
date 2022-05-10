import './BuyCrypto.css'


const BuyCrypto = () => {

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

        <form id='buy-crypto-form'>

            <label htmlFor='username-confirm'>Username Confirm</label>

            <input name='username-confirm' autoComplete="on" placeholder='username-confirm'
                type="text" id='username-confirm' />

            <label htmlFor='deposit'>Deposit</label>

            <input name='deposit' autoComplete="on" placeholder='Deposit'
                type="text" id='deposit' />



            <label htmlFor='crypto-asset'>Crypto Asset</label>

            <select className='crypto-asset' id='crypto-asset'>
                {cryptoEnum.map(asset => (
                    <option >{asset.name}</option>

                ))}


            </select>

            <button className="button" type="submit" >Buy Crypto</button>






        </form>



    );
}


export default BuyCrypto;