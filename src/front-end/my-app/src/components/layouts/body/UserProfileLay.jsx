import React, { Component } from 'react';
import { Switch } from 'react-router-dom'
import Nav from '../navigator/UserNav'

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
                <Switch>
                    
                </Switch>
            </div>
        )
    }
}