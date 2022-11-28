const baseUrl = 'http://localhost:8000';

export const register = async (username, fullName, email, country, password, confirmPassword) => {

    let res = await fetch(`${baseUrl}/api/user/register`, {
        method: 'POST',
        headers: {
            
            'content-type': 'application/json'
        },
        body: JSON.stringify({username, fullName, email, country, password, confirmPassword})
        
    });
    console.log(JSON.stringify({username, fullName, email, country, password, confirmPassword}))

    let jsonResult = await res.json();

    if (res.ok) {
        return res.message;
    } else {
        throw jsonResult.message;
    }

}