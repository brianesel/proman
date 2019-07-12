import React, { Component } from 'react';
import UserRequest from '../../js/requests/UserRequest'

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
            
            return  <li key={key}>
                        <div className="info_header">{key}</div>
                        <div className="info_content">{this.state.user[key]}</div>
                    </li>
        })
        return (
            <div className="user_summary_wrapper">
                <section className="user_basic_info">
                    <p className="section_headers">
                        PERSONAL DETAILS
                    </p>
                    <img alt="its my face" />
                    <div>
                        {this.user_infos}
                    </div>
                </section>
            </div>
        )
    }
}