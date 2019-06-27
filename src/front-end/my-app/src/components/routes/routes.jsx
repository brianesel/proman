import React, { Component } from 'react';
import { Router, Route } from 'react-router-dom';
import App from '../../App.js';

export default class routes extends Component {
  constructor(){
    super()
    console.log("routes.js");
  }
  render(){
    return(
      <Router>
        <Route path='/' component={App}/>
      </Router>
    )
  }
  
} 