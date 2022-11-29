const baseUrl = 'http://localhost:8000';

export const register = async (username, fullName, email, country, password, confirmPassword) => {

    let res = fetch(`${baseUrl}/api/user/register`, {
        method: 'POST',
        headers: {

            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, fullName, email, country, password, confirmPassword })

    });

    res.then((response) => {

        if (response.ok) {

            return response.json().message();
        } else {
            throw new response.json().message()
        }



    });




}