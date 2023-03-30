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

        <form id='form-buy-crypto'>

            <label htmlFor='username-confirm' id='buy-crypto-label'>Username Confirm</label>

            <input name='username-confirm' autoComplete="on" placeholder='Username Confirm'
                type="text" id='username-confirm' />

            <label htmlFor='deposit' id='buy-crypto-label'>Deposit</label>

            <input name='deposit' autoComplete="on" placeholder='Deposit'
                type="text" id='deposit' />



            <label htmlFor='crypto-asset' id='buy-crypto-label'>Crypto Asset</label>

            <select className='crypto-asset' id='crypto-asset'>
                {cryptoEnum.map(asset => (
                    <option id='crypto-asset-option'>{asset.name}</option>

                ))}


            </select>

            <button className="button" type="submit" id='button-buy-crypto '>Buy Crypto</button>






        </form>



    );
}


export default BuyCrypto;