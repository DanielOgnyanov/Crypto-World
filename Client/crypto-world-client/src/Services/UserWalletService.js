const baseUrl = 'http://localhost:8000';


export const getUserWallet = async () => {
  const userStr = localStorage.getItem('user');
  const user = userStr ? JSON.parse(userStr) : null;

  if (!user || !user.accessToken || !user.username) {
    throw new Error("User is not authenticated or missing info");
  }

  const res = await fetch(`${baseUrl}/api/user/wallet`, {
    method: 'POST', 
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${user.accessToken}`,
    },
    body: JSON.stringify({ username: user.username }), // send username in body
  });

  if (!res.ok) {
    const error = await res.text();
    throw new Error(`Error fetching wallet: ${error || res.statusText}`);
  }

  return res.json();
};



export const addCard = async ({ iban, balance, expirationDate, typeCard }) => {
  const userString = localStorage.getItem("user");

  if (!userString) {
    throw new Error("User not authenticated");
  }

  const user = JSON.parse(userString);
  const token = user.accessToken;

  const payload = {
    iban: iban.replace(/\s+/g, ''),
    balance: parseFloat(balance),
    expirationDate,
    typeCard
  };

  const response = await fetch(`${baseUrl}/card/add`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`,  
    },
    body: JSON.stringify(payload)
  });

  if (!response.ok) {
    const errorText = await response.text();
    throw new Error(errorText || 'Failed to add card');
  }

  return await response.json();
};






export async function sendDeposit({ usernameConfirm, deposit, crypto }) {
  try {
    const userString = localStorage.getItem("user");
    const user = JSON.parse(userString);
    const token = user.accessToken;

    if (!token) {
      throw new Error('Authentication token not found.');
    }

    const response = await fetch(`${baseUrl}/api/deposit/add`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      },
      body: JSON.stringify({
        usernameConfirm,
        deposit,
        crypto
      })
    });

    const data = await response.json();

    if (!response.ok) {
      throw new Error(data.error || 'Deposit request failed.');
    }

    return data;
  } catch (error) {
    console.error('Deposit API error:', error.message);
    throw error;
  }
}




export const sellCrypto = async ({ usernameConfirm, sellValue, crypto }) => {
  try {
     const userString = localStorage.getItem("user");
     const user = JSON.parse(userString);
     const token = user.accessToken;

    const response = await fetch(`${baseUrl}/api/sell/execute`, {
      method: 'POST',
     headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`
      },
      body: JSON.stringify({ usernameConfirm, sellValue, crypto })
    });

    if (!response.ok) {
      const errorData = await response.json();
      throw new Error(errorData.message || 'Sell request failed');
    }

    const result = await response.json();
    return result;
  } catch (err) {
    console.error('Sell service error:', err.message);
    throw err;
  }
};




