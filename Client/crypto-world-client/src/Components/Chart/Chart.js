import { Doughnut } from 'react-chartjs-2'


const Chart = () => {


    return (


        <div>
            <Doughnut>
                data{{
                    labels: [
                        'Red',
                        'Blue',
                        'Yellow'
                      ]
                }}


            </Doughnut>

        </div>

    );


}


export default Chart;