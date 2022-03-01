import './HomePage.css'
import * as cryptoService from '../../Services/CryptoService'



const HomePage = () => {

    let cryptoPrices = cryptoService.getCryptoPrice;

    let objCryptoPrices = JSON.parse({id: 1, name: "Bitcoin", price: 45000});

    

    


    

    return (


        <table className="table">
        <thead className="table-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Crypto Name</th>
            <th scope="col">Current Price</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row" >objCryptoPrices.id</th>
            <td >objCryptoPrices.name</td>
            <td >objCryptoPrices.price</td>
        </tr>
        </tbody>
    </table>




           

    );
}


export default HomePage;