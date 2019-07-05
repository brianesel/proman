import React, { Component } from 'react';
import AuthenticationRequest from '../../js/requests/AuthenticationRequest'
import { Link } from 'react-router-dom'
import CryptoJS from 'crypto-js'

class UserDashboard extends Component {

    constructor(props) {
        super(props)

        this.state = {
            message : ''
        }

        this.handleChange = this.handleChange.bind(this)
        this.updateClicked = this.updateClicked.bind(this)
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]
                    : event.target.value
            }
        )
    }

    updateClicked() {
        let cooky = window.localStorage;
        let user = {
            accessToken : cooky.getItem('userOathTokenType')+" "+ (CryptoJS.AES.decrypt((cooky.getItem('accessTokenEncrypted')).toString(), 'somerandomsecretkey')).toString(CryptoJS.enc.Utf8),
            contentType: 'application/json'
        }
        console.log(user.accessToken);
        AuthenticationRequest
            .getUserInfo(user)
            .then((response) => {
                console.log(response);
            })
    }

    render() {
        return (
            <div>
                <h1>hello</h1>
                <div className="container">
                    <button className="btn btn-success" onClick={this.updateClicked}>Update</button>
                </div>
                <Link to="/myprofile">click here</Link>
            </div>
        )
    }
}

export default UserDashboard