import React, { Component } from 'react';
import {BrowserRouter, Route, Link, Router, Switch} from 'react-router-dom';
import './App.scss';
import WelcomePage from './components/welcome/Welcome.jsx'
import LandingPage from './components/welcome/landing/LandingPage'
import SignUp from './components/authen/SignupPage'
import NotFound from './components/error/PageNotFound'
import Login from './components/authen/LoginPage'
import {ProtectedRoute} from './components/router/ProtectedRoute'
import UserDashboard from './components/user/UserDashboard'

class App extends Component {
  constructor(){
    super()
    console.log("app.js");
  }
  render() { 
    return (
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={WelcomePage}/>
          <Route exact path="/landing" component={LandingPage}/>
          <Route path="/signup" component={SignUp}/>
          <Route path="/signin" component={Login}/>
          <ProtectedRoute path="/user" component={UserDashboard}/>
          <Route component={NotFound} />
        </Switch>
      </BrowserRouter>
  )};
}

export default App;
