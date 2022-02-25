import './HomePage.css'
import * as cryptoService from '../../Services/CryptoService'



const HomePage = () => {

    



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
            <th scope="row" >1</th>
            <td >Bitcoin</td>
            <td >42 000</td>
        </tr>
        </tbody>
    </table>




           

    );
}


export default HomePage;