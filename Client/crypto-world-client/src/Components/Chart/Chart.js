import 'chart.js/auto';
import { useEffect, useState } from 'react';
import { Doughnut } from 'react-chartjs-2';
import './Chart.css';
import { getUserWallet } from '../../Services/UserWalletService';

const Chart = () => {
  const [wallet, setWallet] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchWallet = async () => {
      try {
        const data = await getUserWallet();
        setWallet(data);
      } catch (err) {
        console.error('Failed to fetch wallet:', err);
        setError('Could not load wallet data.');
      }
    };

    fetchWallet();
  }, []);

  if (error) {
    return <p className="chart-error">{error}</p>;
  }

  if (!wallet) {
    return <p className="chart-loading">Loading chart...</p>;
  }

  const walletAssets = [
    { name: 'Bitcoin', key: 'bitcoin' },
    { name: 'Ethereum', key: 'ethereum' },
    { name: 'BNB', key: 'binance' },
    { name: 'Cardano', key: 'cardano' },
    { name: 'Tether', key: 'tether' },
    { name: 'Solana', key: 'solana' },
    { name: 'Xrp', key: 'xrp' },
    { name: 'Polkadot', key: 'polkadot' },
    { name: 'Dogecoin', key: 'dogecoin' },
    { name: 'Usdcoin', key: 'usdcoin' }
  ];

  const nonZeroAssets = walletAssets
    .map(asset => ({
      name: asset.name,
      value: wallet[asset.key] || 0
    }))
    .filter(asset => asset.value > 0);

  const dataArr = nonZeroAssets.map(asset => asset.value);
  const labels = nonZeroAssets.map(asset => asset.name);
  const portfolioValue = dataArr.reduce((acc, val) => acc + val, 0);

  const chartData = {
    labels,
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
        generateLabels: function (chart) {
          const data = chart.data;
          if (data.labels.length && data.datasets.length) {
            return data.labels.map((label, i) => {
              const value = data.datasets[0].data[i];
              return {
                text: `${label}: ${value.toFixed(5)}`,
                fillStyle: data.datasets[0].backgroundColor[i],
                strokeStyle: data.datasets[0].backgroundColor[i],
                index: i
              };
            });
          }
          return [];
        }
      }
    },
    tooltip: {
      backgroundColor: "#222",
      bodyColor: "#fff",
      borderColor: "#00feba",
      borderWidth: 1,
      padding: 10,
      callbacks: {
        label: function (context) {
          const label = context.label || '';
          const value = context.raw;
          return `${label}: ${value.toFixed(5)}`;
        }
      }
    }
  }
};


  return (
    <div className='chart-container'>
      <div className='chart-details'>
      <p>Total Portfolio Value In Crypto: <span>{portfolioValue.toLocaleString(undefined, { minimumFractionDigits: 5, maximumFractionDigits: 8 })}</span></p>

      </div>
      {dataArr.length === 0 ? (
        <div className='chart-visual no-data'>
          <p style={{ color: '#ccc', fontStyle: 'italic' }}>
            Your wallet is empty. Start adding crypto to see your portfolio.
          </p>
        </div>
      ) : (
        <div className='chart-visual'>
          <Doughnut data={chartData} options={chartOptions} />
        </div>
      )}
    </div>
  );
};

export default Chart;
