import { useState } from 'react';
import './AddCreditCard.css';

const AddCreditCard = () => {
  const [iban, setIban] = useState('');
  const [balance, setBalance] = useState('');
  const [expirationDate, setExpirationDate] = useState('');

  // Function to format IBAN into groups of 4 characters separated by spaces
  const formatIban = (value) => {
    const alphanumeric = value.replace(/\W/gi, '').toUpperCase();
    const formatted = alphanumeric.match(/.{1,4}/g)?.join(' ') || '';
    return formatted;
  };

  // Handler for IBAN input change
  const handleIbanChange = (e) => {
    const input = e.target.value;
    const formatted = formatIban(input);
    setIban(formatted);
  };

  // List of credit card options
  const cardEnum = Object.freeze([
    { name: 'PAYPAL' },
    { name: 'SKRILL' },
    { name: 'REVOLUT' },
    { name: 'BINANCE' }
  ]);

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    const numericBalance = parseFloat(balance);

    if (numericBalance < 1) {
      alert("Balance must be greater than zero.");
      return;
    }

    if (!expirationDate) {
      alert("Please select an expiration date.");
      return;
    }

    // Process form data here (e.g., send to backend)
    alert("Form submitted successfully!");
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
        maxLength={42} // 34 characters + 8 spaces max
        autoComplete='off'
        required
      />

      <label htmlFor="expiration-date" id='add-credit-card-label'>Expiration Date</label>
      <input
        name='expiration-date'
        id='expiration-date'
        type='month'
        min={new Date().toISOString().slice(0, 7)}
        value={expirationDate}
        onChange={e => setExpirationDate(e.target.value)}
        required
      />

      <label htmlFor="balance" id='add-credit-card-label'>Balance</label>
      <input
        name='balance'
        autoComplete="on"
        placeholder='Balance'
        type="number"
        id='balance'
        min="1"
        value={balance}
        onChange={e => setBalance(e.target.value)}
        required
      />

      <label htmlFor="credit-card" id='add-credit-card-label'>Credit Card</label>
      <select className='credit-card' id='credit-card' required>
        {cardEnum.map((card, index) => (
          <option key={index} value={card.name}>{card.name}</option>
        ))}
      </select>

      <button className="button" type="submit" id='button-credit-card'>Add Card</button>
    </form>
  );
};

export default AddCreditCard;
