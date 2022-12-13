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

        if (!response.ok) {
            throw new response.status;
        }
        localStorage.setItem("usernameRegisterService" ,JSON.stringify (username));
        
        return response.json();

    }).then((data) => {
        console.log(data);
    })




}