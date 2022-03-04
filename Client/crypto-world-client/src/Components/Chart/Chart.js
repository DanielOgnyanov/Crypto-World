import 'chart.js/auto';
import { Doughnut } from 'react-chartjs-2'


const Chart = () => {

  const data = {
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
  
  const options1 = {
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
        fontColor: "#6D7278",
        fontFamily: "kanit light"
      }
    }
  };


  return (

    <>
    <Doughnut
      data={data}
      options={options1}
      height={250}
      width={800}
     
    />
  </>
  );


}


export default Chart;