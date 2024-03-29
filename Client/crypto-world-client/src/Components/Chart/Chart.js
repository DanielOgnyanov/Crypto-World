import 'chart.js/auto';
import { Doughnut } from 'react-chartjs-2'
import './Chart.css'
import * as userWalletService from '../../Services/UserWalletService'


const Chart = () => {


  // Demo Price after i add real time price fetching the backend

  const usersWalletJson =
    [
      { id: 1, name: "Bitcoin", price: 45000 },
      { id: 2, name: "Ethereum", price: 3000 },
      { id: 3, name: "BNB", price: 300 },
      { id: 4, name: "Cardano", price: 1000 },
      { id: 5, name: "Tether", price: 1000 },
      { id: 6, name: "Solana", price: 3000 },
      { id: 7, name: "Xrp", price: 4000 },
      { id: 8, name: "Polkadot", price: 5000 },
      { id: 9, name: "Dogecoin", price: 4000 },
      { id: 10, name: "Usdcoin", price: 3000 }
      
    ];



  let portfolioValue = 0;

  let bitcoin = usersWalletJson[0]['price'];

  let ethereum = usersWalletJson[1]['price'];

  let bnb = usersWalletJson[2]['price']

  let cardano = usersWalletJson[3]['price']

  let tether = usersWalletJson[4]['price']

  let solana = usersWalletJson[5]['price']

  let xrp = usersWalletJson[6]['price']

  let polkadot = usersWalletJson[7]['price']

  let dogecoin = usersWalletJson[8]['price']

  let usdcoin = usersWalletJson[9]['price']



  const dataArr = [bitcoin, ethereum, bnb, cardano, tether, solana, xrp, polkadot, dogecoin, usdcoin]

  for (let i = 0; i < dataArr.length; i++) {
    portfolioValue += dataArr[i];

  }

  const chartData = {
    labels: ["Bitcoin", "Ethereum", "BNB", "Cardano", "Tether", "Solana", "Xrp", "Polkadot", "Dogecoin", "Usdcoin"],
    datasets: [
      {
        data: dataArr,
        backgroundColor: ["yellow", "blue", "#E9C80D", "#0D7EEE", "#07B009", "#E865D8", "#4EB1E7", "#B01D95", "#A18D1B", "#1A7A46"],
        hoverBackgroundColor: ["yellow", "blue", "#E9C80D", "#0D7EEE", "#07B009", "#E865D8", "#4EB1E7", "#B01D95", "#A18D1B", "#1A7A46"],
        borderWidth: 1


      }
    ],
    text: "25%"


  };

  const chartOptions = {
    responsive: true,
    cutoutPercentage: 85,
    maintainAspectRatio: false,
    color: "white",

    plugins: {
      title: {
        display: true,
        text: "Portfolio",
        color: "white",
        font: {
          size: 30,

        }

      },
      legend: {
        display: true,
        position: "bottom",

        labels: {
          font: {
            size: 17
          }
        }

      }
    }

  };





  return (


    <div className='container' id='chart'>

      <div id='details'>
        <p>Total Value: {portfolioValue}</p>
      </div>


      <div className='chart-div' >
        <Doughnut data={chartData} options={chartOptions} height="450px" />
      </div>
    </div>



  );


}


export default Chart;