
import './App.css';
import Navbar from './Components/Navbar';
import Newsapp from './Components/Newsapp';
import React, { Component } from 'react'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
export default class App extends Component {

  static defaultProps = {
    pageSize: 9,

  }

  render() {
    return (
      <Router>
        <Navbar title="Newsapp" about="About Us" />
        <div className="container">
          <Routes>
            <Route  exact path="/" element={<Newsapp pageSize={5} category="general" key="general" />} />
            <Route  exact path="/entertainment" element={<Newsapp pageSize={5} category="entertainment"  key="entertainment" />} />
            <Route  exact path="/business" element={<Newsapp pageSize={5} category="business" key="business"  />} />
            <Route  exact path="/health" element={<Newsapp pageSize={5} category="health" key="health"  />} />
            <Route  exact path="/science" element={<Newsapp pageSize={5} category="science" key="science"  />} />
            <Route  exact path="/sports" element={<Newsapp pageSize={5} category="sports" key="sports"  />} />
            <Route  exact path="/technology" element={<Newsapp pageSize={5} category="technology" key="technology"  />} />
          </Routes>
        </div>
      </Router>
    )
  }
}






