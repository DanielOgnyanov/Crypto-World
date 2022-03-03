import { Doughnut } from 'react-chartjs-2'


const Chart = () => {

    const data = {
        labels: [
          'Red',
          'Blue',
          'Yellow'
        ],
        datasets: [{
          label: 'Dataset',
          data: [300, 50, 100],
          backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(54, 162, 235)',
            'rgb(255, 205, 86)'
          ],
          hoverOffset: 4
        }]
      };


    return (


        <div>
            <Doughnut>
       


            </Doughnut>

        </div>

    );


}


export default Chart;