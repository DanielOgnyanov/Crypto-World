import './HomePage.css'



const HomePage = () => {




    return (


        <table className='table'>
            <thead >
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Crypto Name</th>
                    <th scope="col">Current Price</th>
                </tr>

            </thead>


            <tbody>
            <tr>
            <td>1</td>
            <td>Bitcoin</td>
            <td>42000</td>
        </tr>




            </tbody>

        </table>


    );
}


export default HomePage;