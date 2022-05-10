
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Header from './Components/Header/Header';
import Footer from './Components/Footer/Footer';
import Register from './Components/Register/Register';
import Login from './Components/Login/Login'
import GetStarted from './Components/GetStarted/GetStarted'
import HomePage from './Components/HomePage/HomePage'
import AddCreditCard from './Components/AddCreditCard/AddCreditCard';
import BuyCrypto from './Components/BuyCrypto/BuyCrypto';
import { AuthProvider } from './Context/AuthContext';



function App() {

  return (
    <div className='container' >
      <AuthProvider>
        <Header />

        <Routes>
          <Route exact path="/" exact element={<GetStarted />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />


          <Route path="/home" element={<HomePage />} />
          <Route path="/add-credit-card" element = {<AddCreditCard/>}/>
          <Route path = "/buy-crypto" element = {<BuyCrypto/>}/>

        </Routes>


        <Footer />
      </AuthProvider>

    </div>
  );
}

export default App;
