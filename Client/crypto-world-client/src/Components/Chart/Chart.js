import 'chart.js/auto';
import { Doughnut } from 'react-chartjs-2'


const Chart = () => {

  const chartData = {
    labels: ["Bitcoin", "Ethereum", "BNB"],
    datasets: [
      {
        data: [2, 3, 5],
        backgroundColor: ["#FF6384", "#36A2EB", "#FFCE56"],
        hoverBackgroundColor: ["red", "#36A2EB", "#FFCE56"],
        borderWidth: 1
      }
    ],
    text: "25%"


  };

  const chartOptions = {
    responsive: true,
    cutoutPercentage: 85,
    maintainAspectRatio: false,

    
      plugins: {

        legend: {
          display: true,
          position: "bottom",
         

          labels: {
            usePointStyle: "true",
            fontSize: 12,
            padding: 25,
            fontColor: '#333',
            fontFamily: "kanit light"

          }
        },

        title: {
          display: true,
          fontColor: "white",
          title: "Portfolio"
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