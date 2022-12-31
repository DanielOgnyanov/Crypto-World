import './TableCryptoPrice.css'
import * as cryptoService from '../../../Services/CryptoService'

const TableCryptoPrice = () => {



    return (

        <div id='container-crypto-price-table'>

            <div id='table-price-div '>
                <table id='table-price'>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Market Cap</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Bitcoin</td>
                        <td>16 000</td>
                        <td>$319,855,199,176</td>

                    </tr>
                </table>
            </div>
        </div>

);

}


export default TableCryptoPrice;