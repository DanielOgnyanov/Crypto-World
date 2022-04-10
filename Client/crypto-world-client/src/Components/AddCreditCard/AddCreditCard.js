import './AddCreditCard.css'




const AddCreditCard = () => {


    const cardEnum = Object.freeze(

        'PAYPAL',
        'SKRILL',
        'REVOLUT',
        'BINANCE'

    );



    return (

        <form >
            <label htmlFor="Iban" >Iban</label>
            <input name='iban' autoComplete="on" placeholder='Iban' type="text" id='iban' />


            <label htmlFor="expiration-year">Expiration Year</label>
            <input name='expiration-year' autoComplete="on" placeholder='Expiration Year' type="number" id='expiration-year' />

            <label htmlFor="balance">Balance</label>
            <input name='balance' autoComplete="on" placeholder='Balance' type="number" id='balance' />

            <label htmlFor="credit-card">Credit Card</label>
            <input name='credit-card' autoComplete="on" placeholder='Credit Card'  id='credit-card' />



        </form>


    );
}


export default AddCreditCard;