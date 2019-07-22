import React, { Component } from 'react';
import '../../../../css/landing/contact.scss';

export default class Contact extends Component {

    constructor(props) {
        super(props)
        
        this.state = {
        }
    }

    render() {
        return (
            <div className="contact_container">
                <div className="contact_wrapper">
                    <div className="contact_content">
                        <p className="header">Contact</p>
                        <div className="contact_list">
                            <div className="name info" >
                                {/* <p className="title">Name:</p> */}
                                <input placeholder="Name"/>
                            </div>
                            <div className="email info" >
                                {/* <p className="title">Email:</p> */}
                                <input placeholder="Email"/>
                            </div>
                            <div className="phone_number info" >
                                {/* <p className="title">Phone number</p> */}
                                <input placeholder="Phone"/>
                            </div>
                            <div className="messages info" >
                                {/* <p className="title">Message:</p> */}
                                <textarea placeholder="Message"/>
                            </div>
                        </div>
                        <button>Send</button>
                    </div>
                </div>
            </div>
        )
    }
}