
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Header from './Components/Header/Header';
import Footer from './Components/Footer/Footer';
import Register from './Components/Register/Register';
import Login from './Components/Login/Login'
import GetStartedCard from './Components/GetStartedCard/GetStartedCard'



function App() {
  return (
    <div className='container' >
      <Header/>
      
      <Routes>

       <Route path = "/register" element = {<Register/>}/>
       <Route path = "/login" element = {<Login/>}/>
       <Route path = "/register" element = {<GetStartedCard/>}/>



      </Routes>
     
      
      <Footer/>
     
    </div>
  );
}

export default App;
