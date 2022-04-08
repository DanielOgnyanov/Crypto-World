import './AddCreditCard.css'




const AddCreditCard = () => {



    

    return (

        <form >
            <label htmlFor="Iban" >Iban</label>
            <input name='iban' autoComplete="on" placeholder='Iban' type="text" id='iban' />


            <label htmlFor="expiration-year">Expiration Year</label>
            <input name='expiration-year' autoComplete="on" placeholder='Expiration Year' type="number" id='expiration-year' />

            

            

        </form>


    );
}


export default AddCreditCard ;