import './TopFiveCryptoBuy.css';

const TopFiveCryptoBuy = () => {
  const topFiveCrypto = [
    { id: 1, coinName: 'Bitcoin' },
    { id: 2, coinName: 'Ethereum' }
  ];

  return (
    <form id="form-top-five-crypto-buy">
      <p id="p-top-five-crypto-by-user">Top 5 Crypto Buy By User</p>

      <label htmlFor="username-top-five-crypto" id="label-top-five-crypto-by-user">
        Enter Username:
      </label>
      <input
        name="username"
        autoComplete="on"
        placeholder="Username"
        type="text"
        id="username-top-five-crypto"
      />

      <button type="submit" id="button-find-user-last-five-buy">
        Search
      </button>
    </form>
  );
};

export default TopFiveCryptoBuy;
