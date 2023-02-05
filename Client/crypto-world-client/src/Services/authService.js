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


export const logout = async (username) => {

    let res = fetch(`${baseUrl}/api/user/logout`, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username })
    });

    
    
    
    res.then((response) => {

        if (!response.ok) {
            throw new Error(response.status);
        }

        localStorage.removeItem("usernameLogin");

        return response.json();
    }).catch(error => {
        console.log(error);
    });

}