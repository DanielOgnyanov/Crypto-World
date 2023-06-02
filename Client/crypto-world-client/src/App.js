
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Header from './Components/Header/Header';
import Footer from './Components/Footer/Footer';
import Register from './Components/Register/Register';
import Login from './Components/Login/Login'
import Logout from './Components/Logout/Logout';
import IndexPage from './Components/IndexPage/IndexPage';
import HomePage from './Components/HomePage/HomePage'
import AddCreditCard from './Components/AddCreditCard/AddCreditCard';
import BuyCrypto from './Components/BuyCrypto/BuyCrypto';
import SellCrypto from './Components/SellCrypto/SellCrypto';
import AdminPanel from './Components/AdminPanel/AdminPanel';
import Prices from './Components/IndexPage/Prices/Prices';
import { AuthProvider } from './Context/AuthContext';



function App() {

  return (
    <div className='container' >
      <AuthProvider>
        <Header />

        <Routes>
          <Route exact path="/" exact element={<IndexPage />} />
          <Route path='/prices' element = {<Prices/>}/>
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          


          <Route path="/home" element={<HomePage />} />
          <Route path="/add-credit-card" element = {<AddCreditCard/>}/>
          <Route path = "/buy-crypto" element = {<BuyCrypto/>}/>
          <Route path = "/sell-crypto" element = {<SellCrypto/>}/>
          <Route path = "/admin" element = {<AdminPanel/>}/>
          <Route path="/logout" element={<Logout/>} />

        </Routes>


        <Footer />
      </AuthProvider>

    </div>
  );
}

export default App;
