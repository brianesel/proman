import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import SigninPage from '../authen/LoginPage'
import SignupPage from '../authen/SignupPage'

class WelcomePage extends Component {

    constructor(props) {
        super(props)

        this.state = {
        }
    }

    render() {
        return (
            <Router>
                <div>
                    <h1>Welcome</h1>
                    <Link to="/signin">Sign in</Link><Link to="/signup">Sign up</Link>
                </div>
                <Route path="/signin" exact component={SigninPage} />
                <Route path="/signup" component={SignupPage} />
            </Router>
        )
    }
}

export default WelcomePage