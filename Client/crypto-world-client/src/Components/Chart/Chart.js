import 'chart.js/auto';
import { Doughnut } from 'react-chartjs-2'


const Chart = () => {

  const chartData = {
    labels: ["Bitcoin", "Ethereum", "BNB"],
    datasets: [
      {
        data: [2, 3, 5],
        backgroundColor: ["red", "blue", "yellow"],
        hoverBackgroundColor: ["red", "blue", "yellow"],
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
        color: "white"
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
      options = {chartOptions}

      height={250}
      width={800}

    />

  );


}


export default Chart;