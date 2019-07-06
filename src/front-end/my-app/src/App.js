import React, { Component } from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import './App.scss';
import WelcomePage from './components/welcome/Welcome.jsx'
import LandingPage from './components/welcome/landing/LandingPage'
import SignUp from './components/authen/SignupPage'
import SignIn from './components/authen/LoginPage'
import NotFound from './components/error/PageNotFound'
import {ProtectedRoute} from './components/router/ProtectedRoute'
import {RedirectedRoute} from './components/router/RedirectedRoute'
import UserDashboard from './components/user/UserDashboard'
import UserProfileLay from './components/layouts/body/UserProfileLay'

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
          <Route exact path="/landing" component={LandingPage}/>
          <Route path="/signup" component={SignUp}/>
          <Route path="/signin" component={SignIn}/>
          <ProtectedRoute exact path="/user" component={UserDashboard}/>
          <ProtectedRoute exact path="/myprofile" component={UserProfileLay}/>
          <ProtectedRoute path="/user"/>
          <ProtectedRoute path="/myprofile"/>
          <Route component={NotFound} />
        </Switch>
      </BrowserRouter>
  )};
}

export default App;
