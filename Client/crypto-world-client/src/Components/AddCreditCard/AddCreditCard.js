import { useState } from 'react';
import { useNavigate } from 'react-router-dom';  
import './AddCreditCard.css';
import { addCard } from '../../Services/UserWalletService'; 

const AddCreditCard = () => {
  const [iban, setIban] = useState('');
  const [balance, setBalance] = useState('');
  const [expirationDate, setExpirationDate] = useState('');
  const [typeCard, setTypeCard] = useState(''); 
  const navigate = useNavigate(); 

  const formatIban = (value) => {
    const alphanumeric = value.replace(/\W/gi, '').toUpperCase();
    const formatted = alphanumeric.match(/.{1,4}/g)?.join(' ') || '';
    return formatted;
  };

  const handleIbanChange = (e) => {
    const input = e.target.value;
    const formatted = formatIban(input);
    setIban(formatted);
  };

  const cardEnum = Object.freeze([
    { name: 'PAYPAL' },
    { name: 'SKRILL' },
    { name: 'REVOLUT' },
    { name: 'BINANCE' }
  ]);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const cleanedIban = iban.replace(/\s+/g, '').toUpperCase();
    if (cleanedIban.length < 15 || cleanedIban.length > 20) {
      alert("IBAN must be between 15 and 20 characters.");
      return;
    }

    if (parseFloat(balance) < 100) {
      alert("Balance must be 100 or more.");
      return;
    }

    const expirationRegex = /^(20\d{2})-(0[1-9]|1[0-2])$/;
    if (!expirationRegex.test(expirationDate)) {
      alert("Expiration date must be in the format YYYY-MM.");
      return;
    }

    if (!typeCard) {
      alert("Please select a credit card type.");
      return;
    }

    try {
      await addCard({
        iban: cleanedIban,
        balance,
        expirationDate,
        typeCard
      });
      alert('Card added successfully!');

      
      setIban('');
      setBalance('');
      setExpirationDate('');
      setTypeCard('');
      
      
    } catch (error) {
      console.error('Add card error:', error);
      alert('Error: ' + error.message);
    }
  };

  return (
    <form id='form-credit-card' onSubmit={handleSubmit}>
      <p id='p-add-credit-card'>Add Credit Card</p>

      <label htmlFor="iban" id='add-credit-card-label'>IBAN</label>
      <input
        name='iban'
        id='iban'
        placeholder='XXXX XXXX XXXX XXXX'
        value={iban}
        onChange={handleIbanChange}
        maxLength={42}
        autoComplete='off'
        required
      />

      <label htmlFor="balance" id='add-credit-card-label'>Balance</label>
      <input
        name='balance'
        autoComplete="on"
        placeholder='Balance'
        type="number"
        id='balance'
        min="100"
        value={balance}
        onChange={e => setBalance(e.target.value)}
        required
      />

      <label htmlFor="expiration-date" id='add-credit-card-label'>Expiration Date</label>
      <input
        name='expirationDate'
        id='expiration-date'
        type='month'
        min={new Date().toISOString().slice(0, 7)}
        value={expirationDate}
        onChange={e => setExpirationDate(e.target.value)}
        required
      />

      <label htmlFor="credit-card" id='add-credit-card-label'>Card Type</label>
      <select
        className='credit-card'
        id='credit-card'
        value={typeCard}
        onChange={e => setTypeCard(e.target.value)}
        required
      >
        <option value="">-- Select --</option>
        {cardEnum.map((card, index) => (
          <option key={index} value={card.name}>{card.name}</option>
        ))}
      </select>

      <button className="button" type="submit" id='button-credit-card'>Add Card</button>
    </form>
  );
};

export default AddCreditCard;
