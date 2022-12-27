import './IndexPage.css'
import GetStarted from './GetStarted/GetStarted';
import TableCryptoPrice from './TableCryptoPrice/TableCryptoPrice';

const IndexPage = () => {


    return (

        <div className='index-page'>

            <div className='get-started'>
                <GetStarted />
            </div>

            <div className='table-crypto-price'>
                <TableCryptoPrice/>
            </div>



        </div>





    );

}

export default IndexPage;