import { useState } from "react";

const baseUrl = 'http://localhost:8000';

export const login = async (username, password) => {

    let res = fetch(`${baseUrl}/api/user/login`, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Headers": "*",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "*"
        },
        body: JSON.stringify({ username, password })
    });


    res.then((response) => {

        if (!response.ok) {
            throw new Error(response.status);
        }

        
        localStorage.setItem("usernameLogin", JSON.stringify(username));



        return response.json();
    }).catch(error => {
        console.log(error);
    });

}
export const GetUser = () => {
    let username = useState(localStorage.getItem('usernameLogin') || false);
    return username;
};

export const isAuthenticated = () => {
    return Boolean(GetUser())
};