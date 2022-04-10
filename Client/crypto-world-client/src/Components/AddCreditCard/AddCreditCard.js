import './AddCreditCard.css'




const AddCreditCard = () => {



    

    return (

        <form >
            <label htmlFor="Iban" >Iban</label>
            <input name='iban' autoComplete="on" placeholder='Iban' type="text" id='iban' />


            <label htmlFor="expiration-year">Expiration Year</label>
            <input name='expiration-year' autoComplete="on" placeholder='Expiration Year' type="number" id='expiration-year' />

            <label htmlFor="balance">Balance</label>
            <input name='balance' autoComplete="on" placeholder='Balance' type="number" id='balance' />

            

        </form>


    );
}


export default AddCreditCard ;