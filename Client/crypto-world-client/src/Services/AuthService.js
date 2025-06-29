import { useState } from "react";
import { useAuthContext } from "../Context/AuthContext";

const baseUrl = 'http://localhost:8000';

export const login = async (username, password) => {
  try {
    const res = await fetch(`${baseUrl}/api/user/login`, {
      method: 'POST',
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ username, password })
    });

    if (!res.ok) {
      throw new Error(`HTTP error! Status: ${res.status}`);
    }

    const data = await res.json();

    const user = {
      username,
      accessToken: data.accessToken,
    };

    
    localStorage.setItem("user", JSON.stringify(user));

    return user;
  } catch (error) {
    console.error("Login error:", error);
    throw error;
  }
};



export const logout = async (usernameLogout) => {
  try {
    const res = await fetch(`${baseUrl}/api/user/logout`, {
      method: 'POST',
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ usernameLogout })
    });

    if (!res.ok) {
      throw new Error(`Logout failed: ${res.status}`);
    }

    localStorage.removeItem("user");
    return await res.json();

  } catch (error) {
    console.error("Logout error:", error);
    localStorage.removeItem("user"); // Clear anyway
    throw error;
  }
};

export const getUser = () => {
  const data = localStorage.getItem("user");
  if (!data || data === "null" || data === "undefined") return null;

  try {
    const user = JSON.parse(data);
    return user && typeof user === "object" && user.username ? user : null;
  } catch (e) {
    return null;
  }
};


export const isAuthenticated = () => {
  return Boolean(getUser());
};




export const fetchLoggedUserCount = async () => {
    try {
    const token = localStorage.getItem('token'); 

    const response = await fetch('${baseUrl}/api/admin/logged', {
      method: 'GET',
      headers: {
        'Authorization': `Bearer ${token}`, 
        'Content-Type': 'application/json',
      },
    });

    if (!response.ok) {
      throw new Error('Failed to fetch logged-in user count');
    }

    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching logged-in user count:', error);
    return 0;
  }
};




export async function changeUserRole(username, roleName) {
    try {

         const token = localStorage.getItem('token'); 

        const response = await fetch('http://localhost:8000/api/admin/role', {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${token}`, 
                'Content-Type': 'application/json',
                 
            },
            body: JSON.stringify({ username, roleName })
        });

        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(errorText || 'Failed to change user role');
        }

        return await response.text();
    } catch (error) {
        throw error;
    }
}
