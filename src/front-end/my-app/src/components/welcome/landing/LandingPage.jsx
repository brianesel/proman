import React, { Component } from 'react';
import Navigator from '../../layouts/navigator/LandingNav'
import Body from './LandingBody'
import Footer from '../../layouts/footer/LandingFooter'
import SignupPage from '../../authen/SignupPage'
import { Route, Link, Switch } from "react-router-dom";
import '../../../css/landing/landing.scss'

const landingContainerStyle = {
    width: '100%',
}

const bodyStyle = {
    width: '100%',
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
                <div className="landing_wrapper">
                    <Navigator/>
                    <div className="body_container" style={bodyStyle}>
                        <Switch>
                            <Route exact path="/landing" component={Body}/>
                            <Route path="/landing/about" component={SignupPage}/>
                            <Route path="/landing/contact" component={SignupPage}/>
                            <Route path="/landing/services" component={SignupPage}/>
                        </Switch>
                    </div>
                    <Footer/>
                </div>
            </div>
        )
    }
}

