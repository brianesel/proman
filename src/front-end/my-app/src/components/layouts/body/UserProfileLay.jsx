import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom'
import Nav from '../navigator/UserNav'
import UserProfile from '../../user/UserProfile'

export default class UserProfileLay extends Component {

    constructor(props) {
        super(props)
        
        this.state = {
        }
    }

    render() {
        return (
            <div className="userprofile_wrapper">
                <Nav/>
                <div className="body_wrapper">
                    <p>Headers</p>
                    <Switch>
                        <Route exact path="/myprofile" component={UserProfile}/>
                    </Switch>
                </div>
            </div>
        )
    }
}