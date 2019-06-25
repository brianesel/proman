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
            })
    }

    render() {
        return (
            <div>
                <h1>Sign in</h1>
                <div className="container">
                    {/*<ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}/>*/}
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                    {this.state.showSuccessMessage && <div>Login Sucessful</div>}
                    {/*<ShowLoginSuccessMessage showSuccessMessage=s.st{thiate.showSuccessMessage}/>*/}
                    Login ID (username or email): <input type="text" name="userId" value={this.state.userId} onChange={this.handleChange} />
                    Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                    <button className="btn btn-success" onClick={this.signinClicked}>Sign in</button>
                </div>
                <Link to="/info/user">User</Link>
                <Route path="/info/user" component={UserInfo} />
            </div>
        )
    }
}

export default SignupPage