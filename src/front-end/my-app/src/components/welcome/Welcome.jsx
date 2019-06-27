import React, { Component } from 'react';
import { Router, Switch, Redirect, Route, Link } from "react-router-dom";
import LandingPage from './landing/LandingPage'
import history from '../../js/history'

class Welcome extends Component {

    constructor(props) {
        super(props)
        
        console.log("ưelcome")
        this.state = {
        }
    }

    render() {
        return (
            <div>HIWAKJALWK</div>
        )
    }
}

export default Welcome