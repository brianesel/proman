import React, { Component } from 'react';
import {BrowserRouter, Route, Link, Router, Switch} from 'react-router-dom';
import './App.scss';
import WelcomePage from './components/welcome/Welcome.jsx'
import LandingPage from './components/welcome/landing/LandingPage'
import SignUp from './components/authen/SignupPage'
import NotFound from './components/user/UserInfo'

class App extends Component {
  constructor(){
    super()
    console.log("app.js");
  }
  render() { 
    return (
      <BrowserRouter>
        <Switch>
          <Route exact path="/welcome" component={WelcomePage}/>
          <Route path="/landing" component={LandingPage}/>
          <Route path="/signup" component={SignUp}/>
          <Route component={NotFound} />
        </Switch>
      </BrowserRouter>
  )};
}

export default App;
