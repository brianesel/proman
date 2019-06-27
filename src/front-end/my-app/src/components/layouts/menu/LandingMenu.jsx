import React, { Component } from 'react';
import { BrowserRouter as Route, Link, Router } from "react-router-dom";
import SigninPage from '../../authen/LoginPage'
import SignupPage from '../../authen/SignupPage'
import { PrivateRoute } from '../../router/PrivateRoute'
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
                <div class="wrapper">
                    <div class="branding">
                        <img class="brand_logo"></img>
                        <p class="brand_text"></p>
                    </div>
                    <div class="menu-container">
                        <ul>
                            <li></li>
                        </ul>
                    </div>
                </div>
            </div>
        )
    }
}

export default LandingMenu