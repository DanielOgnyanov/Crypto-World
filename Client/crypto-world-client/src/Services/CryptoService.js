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
    try {
      const response = await fetch(`${baseUrl}/api/index/popular/crypto`, {
        method: 'GET',
        headers: {
          'content-type': 'application/json',
        },
      });
  
      if (!response.ok) {
        throw new Error(response.status);
      }
  
      const data = await response.json();
      console.log(data);
  
      return data;
    } catch (error) {
      console.error('Error fetching data:', error);
      throw error;
    }
  };


  export const getMarketCap24Hour = async () => {
    try {
      const response = await fetch(`${baseUrl}/api/crypto/marketCap4Hour`, {
        method: 'GET',
        headers: {
          'content-type': 'application/json',
        },
      });
  
      if (!response.ok) {
        throw new Error(response.status);
      }
  
      const data = await response.json();
      console.log(data);
  
      return data;
    } catch (error) {
      console.error('Error fetching data:', error);
      throw error;
    }
  };


  export const getPercentageDifferenceInMarketCap = async () => {
    try {
      const response = await fetch(`${baseUrl}/api/crypto/marketCapDifferenceInPercentage`, {
        method: 'GET',
        headers: {
          'content-type': 'application/json',
        },
      });
  
      if (!response.ok) {
        throw new Error(response.status);
      }
  
      const data = await response.json();
      console.log(data);
  
      return data;
    } catch (error) {
      console.error('Error fetching data:', error);
      throw error;
    }
  };



  export const getAllCryptoPrices = async () => {
    try {
      const response = await fetch(`${baseUrl}/api/crypto/prices`, {
        method: 'GET',
        headers: {
          'content-type': 'application/json',
        },
        
      });
  
      if (!response.ok) {
        throw new Error(response.status);
      }
  
      const data = await response.json();
  
      return data;
    } catch (error) {
      console.error('Error fetching data:', error);
      throw error;
    }
  };



  export const getListOfCryptoPrices = async () => {
    try {
      const response = await fetch(`${baseUrl}//api/price/history/list`, {
        method: 'GET',
        headers: {
          'content-type': 'application/json',
        },
        
      });
  
      if (!response.ok) {
        throw new Error(response.status);
      }
  
      const data = await response.json();
  
      return data;
    } catch (error) {
      console.error('Error fetching data:', error);
      throw error;
    }
  };