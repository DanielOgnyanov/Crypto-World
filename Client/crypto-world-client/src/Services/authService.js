const baseUrl = 'http://localhost:8000';

export const login = async (username, password) => {

    let res = fetch(`${baseUrl}/api/user/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            "Access-Control-Allow-Headers": "*",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "*" 
        },
        body: JSON.stringify({ username, password })
    });


    res.then((response) => {

        if (!response.ok) {
            throw new response.status;
        }
        
        localStorage.setItem("username" ,JSON.stringify (username));

        return response.json();
    }).then((data) => {
        console.log(data);
    });

}
    export const getUser = () => {
        let username = localStorage.getItem('username');

        return username;
    };

    export const isAuthenticated = () => {
        return Boolean(getUser())
    };