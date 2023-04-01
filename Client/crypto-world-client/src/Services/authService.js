import { useState } from "react";
import { useAuthContext } from "../Context/AuthContext";

const baseUrl = 'http://localhost:8000';
const { loginData } = useAuthContext(); 

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


export const logout = async (usernameLogout) => {

    console.log(usernameLogout)
    let res = fetch(`${baseUrl}/api/user/logout`, {
        method: 'POST',
        headers: {

            "Content-Type": "application/json"


        },
        body: JSON.stringify({ usernameLogout })
    });


    res.then((response) => {

        if (!response.ok) {
            throw new Error(response.status);
        } else {
            localStorage.removeItem("usernameLogin");
        }

        return response.json();
    }).catch(error => {
        console.log(error);
    });

}