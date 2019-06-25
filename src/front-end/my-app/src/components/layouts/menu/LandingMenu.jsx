import React, { Component } from 'react';
import { BrowserRouter as Route, Link } from "react-router-dom";
import SigninPage from '../../authen/LoginPage'
import SignupPage from '../../authen/SignupPage'
import PrivateRouter from '../../router/PrivateRouter'
import UserInfo from '../../user/UserInfo';
import UserProfile from '../../user/UserProfile'

class LandingMenu extends Component {

    constructor(props) {
        super(props)

        this.state = {
        }
    }

    render() {
        return (
            <div>
                <div>
                    <Link to="/signin" component={LoginPage}>Welcome</Link>
                    <Link to="/signup" component={SignupPage}>Welcome</Link>
                    <PrivateRouter path="/user/profile" component={UserProfile}>My page</PrivateRouter>
                </div>
            </div>
        )
    }
}

export default LandingMenu