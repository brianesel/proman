import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom'
import Nav from '../navigator/UserNav'
import UserProfile from '../../user/UserProfile'
import UserSummary from '../../user/UserSummary'
import UserContact from '../../user/UserContact'
import UserPortfolio from '../../user/UserPortfolio'
import UserResume from '../../user/UserResume'
import '../../../css/user/UserLay.css'
import UserRequest from '../../../js/requests/UserRequest'
import FileDownloader from 'js-file-download'

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
    display: "block",
    marginLeft: "15px"
}
const details_sectionStyle = {
}
const body_wrapperStyle = {
    width: "100%",
    margin : 0
}
const pdfButtonStyle = {
    textAlign: "right"
}
export default class UserProfileLay extends Component {

    constructor(props) {
        super(props) 
        
        this.state = {
        }
    }
    handleUploadFile(event) {
        const data = new FormData();
        //using File API to get chosen file
        let file = event.target.files[0];
        data.append('file', event.target.files[0]);
        data.append('name', 'my_file');
        data.append('description', 'this file is uploaded by young padawan');
        let self = this;
        //calling async Promise and handling response or error situation
        UserRequest.pdfConvert(data).then((response) => {
            console.log("File " + file.name + " is uploaded");
        }).catch(function (error) {
            console.log(error);
            if (error.response) {
                //HTTP error happened
                console.log("Upload error. HTTP error/status code=",error.response.status);
            } else {
                //some other error happened
               console.log("Upload error. HTTP error/status code=",error.message);
            }
        });
    }
    render() {
        return (
            <div className="userprofile_wrapper" style={userprofile_wrapperStyle}>
                <Nav/>
                <div className="section_wrapper" style={section_wrapperStyle}>
                    <p style={headerStyle}>Headers
                        {/* <div>
                            <input type="file" onChange={this.handleUploadFile} />
                        </div> */}
                    </p>
                    <div className="body_wrapper row" style={body_wrapperStyle}>
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