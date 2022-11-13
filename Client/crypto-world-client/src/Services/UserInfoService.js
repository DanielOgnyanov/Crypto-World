const baseUrl = 'http://localhost:8000';

export const findIfUsernameIsTakenInDb = async (username) => {

    let res = await fetch(`${baseUrl}/api/user/username/check`, {
        method: 'POST',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify({ username })
    });

    let jsonResult = await res.json();

    

    if (res.ok) {
         return jsonResult;
    } else {
        throw jsonResult.message;
    }
}