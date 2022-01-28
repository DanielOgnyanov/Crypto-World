const baseUrl = 'http://localhost:5000';

export const login = async (username, password) => {
    let res = await fetch(`${baseUrl}/users?username=` + username, {
        method: 'POST',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    });

    let jsonResult = await res.json();

    if (res.ok) {
        return jsonResult;
    } else {
        throw jsonResult.message;
    }
};