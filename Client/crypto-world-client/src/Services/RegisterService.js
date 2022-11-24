const baseUrl = 'http://localhost:8000';

export const register = async (username, fullName, email, password, country) => {

    let res = await fetch(`${baseUrl}/api/user/register`, {
        method: 'POST',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify({username, fullName, email, password, country})
    });

    let jsonResult = await res.json();

    if (res.ok) {
        return res.message;
    } else {
        throw jsonResult.message;
    }

}