import React, { Component } from 'react'
import AuthenticationRequest from '../../js/requests/AuthenticationRequest';
import CryptoJS from 'crypto-js'
import { Link } from "react-router-dom";
import '../../css/authen/SigninPage.scss'

class SigninPage extends Component {

    constructor(props) {
        super(props)

        this.state = {
            userId: '',
            password: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }

        this.handleUserChange = this.handleUserChange.bind(this)
        this.handlePasswordChange = this.handlePasswordChange.bind(this)
        this.signinClicked = this.signinClicked.bind(this)
    }

    handleUserChange(event) {
        this.setState({
            userId: event.target.value,
        });
    }

    handlePasswordChange(event) {
        this.setState({
            password: event.target.value,
        });
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
            <div className="login_wrapper">
                <div className="login_box">
                    <h1>Sign in</h1>
                    <div className="login_info_container">
                        <div className="login_info userid_container">
                            <p>User ID</p>
                            <input type="text" value={this.state.userId} onChange={this.handleUserChange} placeholder="Email or Username"/>
                        </div>
                        <div className="login_info password_container">
                            <p>Password</p>
                            <input type="password" value={this.state.password} onChange={this.handlePasswordChange} placeholder="Password"/>
                        </div>
                    </div>
                    <button onClick={this.signinClicked}>Submit</button>
                </div>
            </div>
        )
    }
}

export default SigninPage