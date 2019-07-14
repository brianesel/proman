import React, { Component } from 'react';
import UserRequest from '../../js/requests/UserRequest'
import '../../css/user/UserSummary.scss'
import 'react-bootstrap'

export default class UserSummary extends Component {

    constructor(props) {
        super(props)
        this.getUserSummary();
        this.state = {
            user : {
                name:'12',
                age:'',
                location:'',
                degree:'',
                phoneNumber:'',
                email:'',
            }
        }

    }

    getUserSummary(){
        UserRequest
        .getUserInfo()
        .then((response)=>{
            console.log(response)
            this.setState({user:response.data})
        })
    }

    render() {
        this.user_infos = Object.keys(this.state.user).map((key) =>{
            
            return  <li key={key} className="row">
                        <div className="info_header col-6">{key}:</div>
                        <div className="info_content col-6">{this.state.user[key]}</div>
                    </li>
        })
        return (
            <div className="user_summary_wrapper col-md-4">
                <div className="user_summary_content">
                    <section className="user_basic_info user_info">
                        <p className="section_headers">
                            PERSONAL DETAILS
                        </p>
                        <img src="https://picsum.photos/id/259/300/200" alt="its my face" />
                        <div className="user_info_text">
                            {this.user_infos}
                        </div>
                    </section>
                    <section className="user_attachment user_info">
                        <p className="section_headers">
                            ATTACHMENTS
                        </p>
                        <div>
                            <div>Attachment1</div>
                            <div>Attachment2</div>
                        </div>
                    </section>
                    <section className="user_social_media user_info">
                        <p className="section_headers">
                            Social profiles
                        </p>
                        <div>
                            <div>FB</div>
                            <div>Twit</div>
                            <div>What</div>
                            <div>Tele</div>
                        </div>
                    </section>
                    <section className="user_contact user_info">
                        <p className="section_headers">
                            Contact
                        </p>
                        <div>
                            <div>Attachment1</div>
                            <div>Attachment2</div>
                        </div>
                    </section>
                </div>
            </div>
        )
    }
}