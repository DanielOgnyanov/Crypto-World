const baseUrl = 'http://localhost:8000';

export const findIfUsernameIsTakenInDb = async (username) => {

    let res = await fetch(`${baseUrl}/api/user/username/check`, {
        method: 'POST',
        
        headers: {
             
            'content-type': 'application/json'
        },
        body: JSON.stringify({ username })
    });

    let jsonResult = await res.json();

    

    if (res.ok) {
        return res.message;
    } else {
        throw jsonResult.message;
    }
}


export const checkIfTheEmailIsNotTaken = async (email) =>{

    let res = await fetch(`${baseUrl}/api/user/email/check`, {
        method: 'POST',
        
        headers: {
             
            'content-type': 'application/json'
        },
        body: JSON.stringify({ email })
    });

    let jsonResult = await res.json();

    

    if (res.ok) {
        return res.message;
    } else {
        throw jsonResult.message;
    }

}