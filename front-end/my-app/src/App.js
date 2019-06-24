import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import  WelcomePage from './components/welcome'

class App extends Component {
  render(){ 
    return (
    <div className="App">
      <WelcomePage/>
    </div>
  )};
}

export default App;
