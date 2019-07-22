import React, { Component } from 'react'
import { Link } from "react-router-dom";
import AuthenticationRequest from '../../js/requests/AuthenticationRequest';

class SignupPage extends Component {

    constructor(props) {
        super(props)

        this.state = {
            username: '',
            password: '',
            repeatedPassword:'',
            email:'',
            repeatedEmail:'',
            name:'',
            location: '',
            phoneNumber: '',
            degree:'',
            hasLoginFailed: false,
            showSuccessMessage: false
        }

        this.handleChange = this.handleChange.bind(this)
        this.signupClicked = this.signupClicked.bind(this)
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]: event.target.value
            }
        )
    }

    signupClicked() {
        let user = this.state;
        if(this.state.email===this.state.repeatedEmail && this.state.password===this.state.repeatedPassword){
            AuthenticationRequest
                .registerNewUser(user)
                .then((response) => {
                    console.log(response);
                })
        }else {
            console.log('not match')
        }
    }

    render() {
        return (
            <div className="login_wrapper">
                <div className="login_box">
                    <h1>Sign up</h1>
                    <div className="login_info_container">
                        <div className="login_info password_container">
                            <p>Name</p>
                            <input name="name" type="text" value={this.state.name} onChange={this.handleChange} placeholder="Name"/>
                        </div>
                        <div className="login_info password_container">
                            <p>Email</p>
                            <input name="email" type="text" value={this.state.email} onChange={this.handleChange} placeholder="Email@email.com"/>
                        </div>
                        <div className="login_info password_container">
                            <p>Repeat email</p>
                            <input name="repeatedEmail" type="text" value={this.state.repeatedEmail} onChange={this.handleChange} placeholder="Password"/>
                        </div>
                        <div className="login_info userid_container">
                            <p>Username</p>
                            <input name="username" type="text" value={this.state.userId} onChange={this.handleChange} placeholder="Username"/>
                        </div>
                        <div className="login_info password_container">
                            <p>Password</p>
                            <input name="password" type="password" value={this.state.password} onChange={this.handleChange} placeholder="Password"/>
                        </div>
                        <div className="login_info password_container">
                            <p>Repreat password</p>
                            <input name="repeatedPassword" type="password" value={this.state.repeatedPassword} onChange={this.handleChange} placeholder="Password"/>
                        </div>
                        <div className="login_info password_container">
                            <p>Phone</p>
                            <input name="phoneNumber" type="number" value={this.state.phoneNumber} onChange={this.handleChange} placeholder="0123456789"/>
                        </div>
                        <div className="login_info password_container">
                            <p>Location</p>
                            <input name="location" type="text" value={this.state.location} onChange={this.handleChange} placeholder="Location"/>
                        </div>
                        <div className="login_info password_container">
                            <p>Degree</p>
                            <input name="degree" type="text" value={this.state.degree} onChange={this.handleChange} placeholder="Degree"/>
                        </div>
                    </div>
                    <button onClick={this.signupClicked}>Submit</button>
                    <Link className="link_after_submit" to="/signin">Already registered?</Link>
                </div>
            </div>
        )
    }
}

export default SignupPage