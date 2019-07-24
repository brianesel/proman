import React, { Component } from 'react';
import '../../../../css/landing/contact.scss';
import request from '../../../../js/requests/landingpagerequest'

export default class Contact extends Component {

    constructor(props) {
        super(props)
        
        this.state = {
            senderName: '',
            senderEmail:'',
            mailSubject:'',
            phoneNumber:'',
            messsage:''
        }
        this.handleChange = this.handleChange.bind(this)
        this.sendButtonClicked = this.sendButtonClicked.bind(this)
    }

    sendButtonClicked(){
        let sendMessage = this.state;
        request.sendMessage(sendMessage);
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]: event.target.value
            }
        )
    }

    render() {
        return (
            <div className="contact_container">
                <div className="contact_wrapper">
                    <div className="contact_content">
                        <p className="header">Contact</p>
                        <div className="body_icon"><i className="fa fa-rainbow"/></div>
                        <div className="contact_list">
                            <div className="name info" >
                                {/* <p className="title">Name:</p> */}
                                <input name="senderName" value={this.state.senderName} onChange={this.handleChange} type="text" placeholder="Name"/>
                            </div>
                            <div className="email info" >
                                {/* <p className="title">Email:</p> */}
                                <input name='senderEmail' value={this.state.senderEmail} onChange={this.handleChange} type="email" placeholder="Email"/>
                            </div>
                            <div className="phone_number info" >
                                {/* <p className="title">Phone number</p> */}
                                <input name='phoneNumber' value={this.state.phoneNumber} onChange={this.handleChange} type="number" placeholder="Phone"/>
                            </div>
                            <div className="subject info" >
                                {/* <p className="title">Phone number</p> */}
                                <input name='mailSubject' value={this.state.mailSubject} onChange={this.handleChange} type="text" placeholder="Hello"/>
                            </div>
                            <div className="messages info" >
                                {/* <p className="title">Message:</p> */}
                                <textarea name='message' value={this.state.message} onChange={this.handleChange} placeholder="Message"/>
                            </div>
                        </div>
                        <button onClick={this.sendButtonClicked}>Send</button>
                    </div>
                </div>
            </div>
        )
    }
}