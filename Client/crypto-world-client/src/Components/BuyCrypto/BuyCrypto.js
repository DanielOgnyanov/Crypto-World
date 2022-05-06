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
        { name: 'USDC' },
    ]);







    return (

        <form id='buy-crypto-form'>

            <label htmlFor='username-confirm'>Username Confirm</label>
            <input name='username-confirm' autoComplete="on" placeholder='username-confirm'
                type="text" id='username-confirm' />

            <label htmlFor='deposit'>Deposit</label>
            <input name='deposit' autoComplete="on" placeholder='deposit'
                type="text" id='deposit' />


            <select className='credit-card' id='credit-card'>
                {cryptoEnum.map(card => (
                    <option id='credit-card-option'>{cryptoEnum.name}</option>

                ))}


            </select>






        </form>



    );
}


export default BuyCrypto;