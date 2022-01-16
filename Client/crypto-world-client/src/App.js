
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Header from './Components/Header/Header';
import Footer from './Components/Footer/Footer';
import Register from './Components/Register/Register';
import GetStartedCard from './Components/GetStartedCard/GetStartedCard'



function App() {
  return (
    <div className='container' >
      <Header/>
      
      <Routes>

       <Route path = "/register" element = {<Register/>}/>
       <Route path = "/register" element = {<GetStartedCard/>}/>


      </Routes>
     
      
      <Footer/>
     
    </div>
  );
}

export default App;
