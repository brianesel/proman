import React, { Component } from 'react';
import { BrowserRouter as Route, Link } from "react-router-dom";
import LandingPage from './landing/LandingPage'

class WelcomePage extends Component {

    constructor(props) {
        super(props)

        this.state = {
        }
    }

    render() {
        return (
            <div>
                <div>
                    <Link to="/landing">Welcome</Link>
                </div>
                <Route path="/landing" exact component={LandingPage} />
            </div>
        )
    }
}

export default WelcomePage