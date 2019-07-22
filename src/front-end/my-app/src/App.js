import React, { Component } from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import './App.scss';
import WelcomePage from './components/welcome/Welcome.jsx'
import LandingPage from './components/welcome/landing/LandingPage'
import SignUp from './components/authen/SignupPage'
import SignIn from './components/authen/LoginPage'
import NotFound from './components/error/PageNotFound'
import {ProtectedRoute} from './components/router/ProtectedRoute'
import UserDashboard from './components/user/UserDashboard'
import UserProfileLay from './components/layouts/body/UserProfileLay'
import 'bootstrap/dist/css/bootstrap.css';

class App extends Component {
  render() { 
    return (
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={WelcomePage}/>
          <Route exact path="/welcome" component={WelcomePage}/>
          <Route path="/landing" component={LandingPage}/>
          <Route path="/signup" component={SignUp}/>
          <Route path="/signin" component={SignIn}/>
          <ProtectedRoute exact path="/user" component={UserDashboard}/>
          <ProtectedRoute path="/myprofile" component={UserProfileLay}/>
          <ProtectedRoute path="/user"/>
          <Route component={NotFound} />
        </Switch>
      </BrowserRouter>
  )};
}

export default App;
