import React, { Component } from 'react';
import { BrowserRouter as Route, Link } from "react-router-dom";
import SigninPage from '../../authen/LoginPage'
import SignupPage from '../../authen/SignupPage'

class LandingPage extends Component {

    constructor(props) {
        super(props)

        this.state = {
        }
    }

    render() {
        return (
            <div>
                <div>
                    <Link to="/signin">Welcome</Link>
                    <Link to="/signin">Welcome</Link>
                    <Link to="/user/profile">My page</Link>
                </div>
                <Route path="/landing" exact component={LandingPage} />
                <Route path="/landing" exact component={LandingPage} />
            </div>
        )
    }
}

export default LandingPage