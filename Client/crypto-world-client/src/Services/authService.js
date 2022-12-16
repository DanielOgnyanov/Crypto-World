const baseUrl = 'http://localhost:8000';

export const login = async (username, password) => {
    
    let res = fetch(`${baseUrl}/api/user/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    });

    if (res.ok) {
        return jsonResult;
    } else {
        throw jsonResult.message;
    }
};


export const getUser = () => {
    let username = localStorage.getItem('username');

    return username;
};

export const isAuthenticated = () => {
    return Boolean(getUser())
};