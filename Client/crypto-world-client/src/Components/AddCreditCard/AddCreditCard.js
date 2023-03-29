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

             <p>Add Credit Card</p>


            <label htmlFor="Iban" id='add-credit-card-label'>Iban</label>
            <input name='iban' autoComplete="on" placeholder='Iban' type="text" id='iban' />


            <label htmlFor="expiration-year" id='add-credit-card-label'>Expiration Year</label>
            <input name='expiration-year' autoComplete="on" placeholder='Expiration Year' type="number" id='expiration-year' />

            <label htmlFor="balance" id='add-credit-card-label'>Balance</label>
            <input name='balance' autoComplete="on" placeholder='Balance' type="number" id='balance' />

            <label htmlFor="credit-card" id='add-credit-card-label'>Credit Card</label>


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