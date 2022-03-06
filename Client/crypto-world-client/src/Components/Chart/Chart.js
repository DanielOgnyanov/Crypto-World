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
    legend: {
      display: true,
      position: "bottom",
      usePointStyle: "true",
      
      labels: {
        fontSize: 12,
        padding: 25,
        fontColor: "white",
        fontFamily: "kanit light"
        
      }
    },
    title: {
      display: true,
      title: "Portfolio"
    }
  };


  return (

    <>
    <Doughnut
      data={chartData}
      options={chartOptions}
      
      height={250}
      width={800}
     
    />
  </>
  );


}


export default Chart;