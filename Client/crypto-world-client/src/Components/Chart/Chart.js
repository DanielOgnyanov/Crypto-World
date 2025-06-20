import 'chart.js/auto';
import { Doughnut } from 'react-chartjs-2';
import './Chart.css';

const Chart = () => {
  const usersWalletJson = [
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

  const dataArr = usersWalletJson.map(asset => asset.price);
  const portfolioValue = dataArr.reduce((acc, val) => acc + val, 0);

  const chartData = {
    labels: usersWalletJson.map(asset => asset.name),
    datasets: [
      {
        data: dataArr,
        backgroundColor: [
          "#f39c12", "#2980b9", "#e74c3c", "#9b59b6", "#1abc9c",
          "#2ecc71", "#f1c40f", "#e67e22", "#3498db", "#95a5a6"
        ],
        hoverBackgroundColor: [
          "#f5b041", "#5dade2", "#ec7063", "#af7ac5", "#48c9b0",
          "#58d68d", "#f4d03f", "#edbb99", "#85c1e9", "#aab7b8"
        ],
        borderWidth: 1
      }
    ]
  };

  const chartOptions = {
    responsive: true,
    maintainAspectRatio: false,
    cutout: '65%',
    plugins: {
      title: {
        display: true,
        text: "Your Crypto Portfolio",
        color: "#00feba",
        font: {
          size: 26,
          weight: "bold",
        },
        padding: {
          bottom: 20
        }
      },
      legend: {
        display: true,
        position: "bottom",
        labels: {
          color: "#ffffff",
          font: {
            size: 14,
            weight: "500"
          },
          boxWidth: 18,
          padding: 15,
        }
      },
      tooltip: {
        backgroundColor: "#222",
        bodyColor: "#fff",
        borderColor: "#00feba",
        borderWidth: 1,
        padding: 10
      }
    }
  };

  return (
    <div className='chart-container'>
      <div className='chart-details'>
        <p>Total Portfolio Value: <span>${portfolioValue.toLocaleString()}</span></p>
      </div>
      <div className='chart-visual'>
        <Doughnut data={chartData} options={chartOptions} />
      </div>
    </div>
  );
};

export default Chart;
