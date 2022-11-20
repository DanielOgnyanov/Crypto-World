const baseUrl = 'http://localhost:8000';

export const register = async (username, fullname, email, password) => {

    let res = await fetch(`${baseUrl}/api/user/register`, {
        method: 'POST',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    });

}