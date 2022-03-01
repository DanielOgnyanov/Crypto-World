import './HomePage.css'
import * as cryptoService from '../../Services/CryptoService'



const HomePage = () => {

    const cryptoPrices = cryptoService.getCryptoPrice;

    const cryptoItem = [{ id: 1, name: "Bitcoin", price: 45000 }];









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
                {cryptoItem.map(Item => (

                    <tr>
                        <th scope="row" >{Item.id}</th>
                        <td >{Item.name}</td>
                        <td >{Item.price}</td>
                    </tr>


                ))}

            </tbody>
        </table>






    );
}


export default HomePage;