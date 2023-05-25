const baseUrl = 'http://localhost:8000';

export const getCryptoPrice = async () => {
    let res = fetch(`${baseUrl}/api/getCryptoPrice`, {
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


export const getPopularCryptoPrice = async () => {

    let res = fetch(`${baseUrl}/api/index/popular/crypto`, {
        method: 'GET',
        headers: {
            'content-type': 'application/json'
        }
    });

    res.then((response) => {

        if (!response.ok) {
            throw new response.status;
        }
        
        return response.json();

    }).then((data) => {
        console.log(data);
    })

}