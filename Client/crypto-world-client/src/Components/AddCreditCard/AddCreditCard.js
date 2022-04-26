import './AddCreditCard.css'




const AddCreditCard = () => {


    const cardEnum = Object.freeze([
        
        { name: 'PAYPAL' },
        { name: 'SKRILL' },
        { name: 'REVOLUT' },
        { name: 'BINANCE' }
    ]);



    return (

        <form id='form-credit-card'>
            <label htmlFor="Iban" >Iban</label>
            <input name='iban' autoComplete="on" placeholder='Iban' type="text" id='iban' />


            <label htmlFor="expiration-year">Expiration Year</label>
            <input name='expiration-year' autoComplete="on" placeholder='Expiration Year' type="number" id='expiration-year' />

            <label htmlFor="balance">Balance</label>
            <input name='balance' autoComplete="on" placeholder='Balance' type="number" id='balance' />

            <label htmlFor="credit-card">Credit Card</label>


            <select className='credit-card' id='credit-card'>
                {cardEnum.map(card => (
                    <option id='credit-card-option'>{card.name}</option>

                ))}


            </select>

            <button className="button" type="submit" id='button-credit-card'>Add Card</button>

        </form>


    );
}


export default AddCreditCard;