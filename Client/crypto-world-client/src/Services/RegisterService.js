const baseUrl = 'http://localhost:8000';

export const register = async (username, fullname, email, password) => {

    let res = await fetch(`${baseUrl}/api/user/register`, {
        method: 'POST',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify({username, fullname, email, password})
    });

    let jsonResult = await res.json();

    if (res.ok) {
        return jsonResult;
    } else {
        throw jsonResult.message;
    }

}