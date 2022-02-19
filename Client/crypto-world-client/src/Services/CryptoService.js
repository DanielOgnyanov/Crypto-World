const baseUrl = 'http://localhost:8000';

export const getCryptoPrice = async () => {
    let res = await fetch(`${baseUrl}/api/getCryptoPrice`, {
        method: 'GET',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify()
    });

    let jsonResult = await res.json();

    if (res.ok) {
        return jsonResult;
    } else {
        throw jsonResult.message;
    }
};