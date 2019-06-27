import React, { Component } from 'react';
import {Route, Link} from 'react-router-dom';
import './App.css';
import WelcomePage from './components/welcome/Welcome.jsx'
import LandingPage from './components/welcome/landing/LandingPage'

class App extends Component {
  constructor(){
    super()
    console.log("app.js");
  }
  render() { 
    return (
      <div>
        <Route exact path="/" component={WelcomePage} />
        <Route path="/landing" component={LandingPage} />
      </div>
  )};
}

export default App;
