const baseUrl = 'http://localhost:8000';


export const getUserWallet = async () => {
  const userStr = localStorage.getItem('user');
  const user = userStr ? JSON.parse(userStr) : null;

  if (!user || !user.accessToken || !user.username) {
    throw new Error("User is not authenticated or missing info");
  }

  const res = await fetch(`${baseUrl}/api/user/wallet`, {
    method: 'POST', // changed from GET to POST
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

