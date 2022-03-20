import 'chart.js/auto';
import { Doughnut } from 'react-chartjs-2'
import './Chart.css'
import * as userWalletService from '../../Services/UserWalletService'


const Chart = () => {


  const usersWalletJson = [{ id: 1, name: "Bitcoin", price: 4 },

  { id: 2, name: "Ethereum", price: 3000 }];

  

  let portfolioValue = 0;

  const bitcoin =  usersWalletJson[1].price;

  const ethereum = 1;

  const bnb = 3;

  const dataArr = [bitcoin, ethereum, bnb]

  for(let i = 0; i < dataArr.length; i++){
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