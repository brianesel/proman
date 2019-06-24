import React, { Component } from 'react';
import './App.css';
import WelcomePage from './components/welcome/Welcome.jsx'

class App extends Component {
  render() { 
    return (
      <div className="App">
        <WelcomePage />
      </div>
  )};
}

export default App;
