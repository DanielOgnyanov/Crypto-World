import 'chart.js/auto';
import { Doughnut } from 'react-chartjs-2'
import './Chart.css'
import * as userWalletService from '../../Services/UserWalletService'


const Chart = () => {


  const usersWalletJson = [{ id: 1, name: "Bitcoin", price: 45000 },

  { id: 2, name: "Ethereum", price: 3000 },
  {id: 3, name: "BNB", price: 300}];

  

  let portfolioValue = 0;

  let bitcoin =  usersWalletJson[0]['price'];
  

  let ethereum = usersWalletJson[1]['price'];

  let bnb = usersWalletJson[2]['price']

  

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