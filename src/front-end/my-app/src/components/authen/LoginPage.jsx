import React, { Component } from 'react'
import AuthenticationRequest from '../../js/requests/AuthenticationRequest';
import CryptoJS from 'crypto-js'
import UserInfo from '../user/UserInfo'
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

class SignupPage extends Component {

    constructor(props) {
        super(props)

        this.state = {
            userId: '',
            password: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }

        this.handleChange = this.handleChange.bind(this)
        this.signinClicked = this.signinClicked.bind(this)
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]
                    : event.target.value
            }
        )
    }

    signinClicked() {
        let user = this.state;
        let cooky = window.localStorage;
        AuthenticationRequest
            .loginUser(user)
            .then((response) => {
                cooky.setItem('accessTokenEncrypted',CryptoJS.AES.encrypt(response.data.accessToken,'somerandomsecretkey'));
                cooky.setItem('userOathTokenType', response.data.tokenType);
                AuthenticationRequest
                    .checkUserLoggedin(response.data.tokenType + " " + response.data.accessToken)
                    .then((response) => {
                        if (response.data === true || response.data === "true"){
                            AuthenticationRequest.isAuthenticated = true;
                        }
                        else { console.log(response.data)}
                    })
            })
            .catch()
    }

    render() {
        return (
            <div>
                <h1>Sign in</h1>
                <div className="container">
                </div>
                <Link to="/info/user">User</Link>
                <Route path="/info/user" component={UserInfo} />
            </div>
        )
    }
}

export default SignupPage