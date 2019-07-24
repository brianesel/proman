import React, { Component } from 'react';
import { Route, Link, Switch } from "react-router-dom";
import AboutMe from './LandingBodyComponent/AboutMe'
import Services from './LandingBodyComponent/Services'
import Contact from './LandingBodyComponent/Contact'
import AboutTheApp from './LandingBodyComponent/AboutTheApp';

export default class LandingBody extends Component {

    constructor(props) {
        super(props)
        
        this.state = {
        }
    }

    render() {
        return (
            <div>
                <Route exact path="/landing" component={AboutMe}/>
                <Route exact path="/landing" component={Services}/>
                <Route exact path="/landing" component={AboutTheApp}/>
                <Route exact path="/landing" component={Contact}/>
            </div>
        )
    }
}