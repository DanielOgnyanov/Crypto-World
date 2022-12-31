const baseUrl = 'http://localhost:8000';

export const getCryptoPrice = async () => {
    let res = await fetch(`${baseUrl}/api/getCryptoPrice`, {
        method: 'GET',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify()
    });

    
    res.then((response) => {

        if (!response.ok) {
            throw new Error(response.status);
        }

        return response.json();
    }).catch(error => {
        console.log(error);
    });
};