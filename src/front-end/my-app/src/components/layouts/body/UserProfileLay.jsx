import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom'
import Nav from '../navigator/UserNav'
import UserProfile from '../../user/UserProfile'
import UserSummary from '../../user/UserSummary'
import UserContact from '../../user/UserContact'
import UserPortfolio from '../../user/UserPortfolio'
import UserResume from '../../user/UserResume'
import '../../../css/user/UserLay.css'

const section_wrapperStyle = {
    paddingTop: "50px",
    width: "75%",
    margin: 'auto'
}
const userprofile_wrapperStyle = {
    backgroundColor: "#f5f5f5"
}
const headerStyle = {
    position: "relative",
    fontSize: "25px",
    marginTop: "45px",
    textTransform: "uppercase",
    fontWeight: "800",
    display: "block"
}
const details_sectionStyle = {
}
export default class UserProfileLay extends Component {

    constructor(props) {
        super(props) 
        
        this.state = {
        }
    }

    render() {
        return (
            <div className="userprofile_wrapper" style={userprofile_wrapperStyle}>
                <Nav/>
                <div className="section_wrapper" style={section_wrapperStyle}>
                    <p style={headerStyle}>Headers</p>
                    <div className="body_wrapper row">
                        <UserSummary />
                        <Switch className="details_info" style={details_sectionStyle}>
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