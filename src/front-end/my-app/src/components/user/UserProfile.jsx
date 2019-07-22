import React, { Component } from 'react';
import '../../css/user/UserProfile.scss'

export default class UserProfile extends Component {

    constructor(props) {
        super(props)
        
        this.state = {
        }
    }

    render() {
        return (
            <div className="user_profile_wrapper user_details_info col-md-8 col-lg-8">
                <section className="about_me">
                    <p className="headers">About me</p>
                    <p className="content_text">
                        asdfawekjmalkwejr;alwekr;alwekra/wle
                    </p>
                </section>
                <section className="about_me">
                    <p className="headers">Services</p>
                    <p className="content_text">
                        asdfawekjmalkwejr;alwekr;alwekra/wle
                    </p>
                </section>
                <section className="about_me">
                    <p className="headers">Skills</p>
                    <p className="content_text">
                        asdfawekjmalkwejr;alwekr;alwekra/wle
                    </p>
                </section>
            </div>
        )
    }
}