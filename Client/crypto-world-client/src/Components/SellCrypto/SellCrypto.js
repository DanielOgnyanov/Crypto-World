import './SellCrypto.css'



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

        <form id='form-sell-crypto'>
            
            <p id='p-sell-crypto'>Sell Crypto Asset</p>
            
            <label htmlFor='username-confirm' id='sell-crypto-label'>Username Confirm</label>

            <input name='username-confirm' autoComplete="on" placeholder='Username Confirm'
                type="text" id='username-confirm' />

            <label htmlFor='sell-value' id='sell-crypto-label'>Sell Value</label>

            <input name='sell-value' autoComplete="on" placeholder='Sell Value'
                type="number"  id="sell-value"/>


            <label htmlFor='crypto-asset' id='sell-crypto-label'>Crypto Asset</label>

            <select id='crypto-asset'>
                {cryptoEnum.map(asset => (
                    <option id='crypto-asset-option'>{asset.name}</option>

                ))}


            </select>

            <button className="button" type="submit" id='button-sell-crypto'>Sell Crypto</button>



        </form>



    );
}


export default SellCrypto;