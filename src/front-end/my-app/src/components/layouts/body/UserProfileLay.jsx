import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom'
import Nav from '../navigator/UserNav'
import UserProfile from '../../user/UserProfile'
import UserSummary from '../../user/UserSummary'
import UserContact from '../../user/UserContact'
import UserPortfolio from '../../user/UserPortfolio'
import UserResume from '../../user/UserResume'

const section_wrapperStyle = {
    paddingTop: "50px",
    width: "90%",
    margin: 'auto'
}
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
                <div className="section_wrapper" style={section_wrapperStyle}>
                    <p>Headers</p>
                    <div className="body_wrapper">
                        <UserSummary/>
                        <Switch>
                            <Route exact path="/myprofile" component={UserProfile}/>
                            <Route path="/myprofile/resume" component={UserResume}/>
                            <Route path="/myprofile/portfolio" component={UserPortfolio}/>
                            <Route path="/myprofile/contact" component={UserContact}/>
                        </Switch>
                    </div>
                </div>
            </div>
        )
    }
}