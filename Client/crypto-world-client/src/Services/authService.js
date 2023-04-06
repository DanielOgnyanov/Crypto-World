import { useState } from "react";
import { useAuthContext } from "../Context/AuthContext";

const baseUrl = 'http://localhost:8000';

export const Login = async (username, password) => {
    const { loginData } = useAuthContext();

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

        loginData(username);

        return response.json();
    }).catch(error => {
        console.log(error);
    });

}


export const Logout = async (usernameLogout) => {
    
    const { logoutData } = useAuthContext();

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
        }

       

        return response.json();
    }).catch(error => {
        console.log(error);
    });

}