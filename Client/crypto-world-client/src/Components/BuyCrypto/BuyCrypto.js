import './BuyCrypto.css'


const BuyCrypto = () => {







    return (

        <form id='buy-crypto-form'>

            <label htmlFor='username-confirm'>Username Confirm</label>
            <input name='username-confirm' autoComplete="on" placeholder='username-confirm'
                type="text" id='username-confirm' />

            <label htmlFor='deposit'>Deposit</label>
            <input name='deposit' autoComplete="on" placeholder='deposit'
                type="text" id='deposit' />







        </form>



    );
}


export default BuyCrypto;