import './App.css'
import LoginComponent from './components/login/login'
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import HeaderComponent from './components/header'
import MainComponent from './components/main/usermain'
import Boleta from './components/grid/ticket/boleta';
function App() {
  return (
    <>
      <HeaderComponent/>
      <Routes>
        <Route path="/" element={<LoginComponent />} />
        <Route path="/main" element={<MainComponent />} />
        <Route path="/boleta/" element={<Boleta />} />
      </Routes>
    </>
  )
}

export default App
