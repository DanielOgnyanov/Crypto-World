import 'chart.js/auto';
import { Doughnut } from 'react-chartjs-2'


const Chart = () => {

  const chartData = {
    labels: ["Bitcoin", "Ethereum", "BNB","Cardano", "Tether", "Solana", "Xrp", "Polkadot", "Dogecoin", "Usdcoin"],
    datasets: [
      {
        data: [2, 3, 5, 1, 1, 1 ],
        backgroundColor: ["yellow", "blue", "#E9C80D", "#0D7EEE", "#07B009", "#E865D8 "],
        hoverBackgroundColor: ["yellow", "blue", "#E9C80D", "#0D7EEE", "#07B009", "#E865D8 "],
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
        font:{
          size: 30
        }
        
      },
      legend: {
        display: true,
        position: "bottom"
      }
    }

  };


  return (


    <Doughnut
      data={chartData}
      options={chartOptions}

      height={250}
      width={800}

    />

  );


}


export default Chart;