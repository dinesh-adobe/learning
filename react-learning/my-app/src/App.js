import './App.css';
import About from './components/About';
import Navbar from "./components/Navbar";
import Textform from './components/Textform';
import {   BrowserRouter as Router,  Routes,  Route} from "react-router-dom";
function App() {
  return (
    <>
    <Router>
     <Navbar title ="Droid" about="About Us" />
     <div className="container"> 
      <Routes>
        <Route path="/" element={  <div className='conatiner'> <Textform heading="Enter text below" /></div>}/>   
        <Route path="/about"  element={<About />}/>  
      </Routes>
      </div>
    </Router>
    </>
  );
}

export default App;

