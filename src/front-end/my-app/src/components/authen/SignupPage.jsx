import React, { Component } from 'react'
import AuthenticationRequest from '../../js/requests/AuthenticationRequest';

class SignupPage extends Component {

    constructor(props) {
        super(props)

        this.state = {
            username: '',
            password: '',
            email:'',
            name:'',
            hasLoginFailed: false,
            showSuccessMessage: false
        }

        this.handleChange = this.handleChange.bind(this)
        this.signupClicked = this.signupClicked.bind(this)
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]
                    : event.target.value
            }
        )
    }

    signupClicked() {
        let user = this.state;
        console.log(user);
        AuthenticationRequest
            .registerNewUser(user)
            .then((response) => {
                console.log(response);
            })
    }

    render() {
        return (
            <div>
                <h1>Sign up</h1>
                <div className="container">
                    Name: <input type="text" name="name" value={this.state.name} onChange={this.handleChange} />
                    Username: <input type="text" name="username" value={this.state.username} onChange={this.handleChange} />
                    Email: <input type="text" name="email" value={this.state.email} onChange={this.handleChange} />
                    Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                    <button className="btn btn-success" onClick={this.signupClicked}>Sign up</button>
                </div>
            </div>
        )
    }
}

export default SignupPage