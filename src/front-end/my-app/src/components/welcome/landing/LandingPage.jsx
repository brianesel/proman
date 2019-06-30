import React, { Component } from 'react';
import Navigator from '../../layouts/navigator/LandingNav'
import Body from './LandingBody'
import Footer from '../../layouts/footer/LandingFooter'
import SignupPage from '../../authen/SignupPage'
import { Route, Link, Router, Switch } from "react-router-dom";

const landingContainerStyle = {
    maxWidth: '1500px',
    padding: '15px',
    margin: 'auto'
}

export default class LandingPage extends Component {

    constructor(props) {
        super(props)
        this.state = {
        }
    }

    render() {
        return (
            <div className="landing_container" style={landingContainerStyle}>
                <Navigator/>
                <Switch>
                    <Route exact path="/landing" component={Body}/>
                    <Route path="/landing/about" component={SignupPage}/>
                    <Route path="/landing/contact" component={SignupPage}/>
                    <Route path="/landing/services" component={SignupPage}/>
                </Switch>
                <Footer/>
            </div>
        )
    }
}

