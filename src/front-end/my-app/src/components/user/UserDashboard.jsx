import React, { Component } from 'react';
import UserRequest from '../../js/requests/UserRequest'
import { Link } from 'react-router-dom'

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
        UserRequest
            .getUserInfo()
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