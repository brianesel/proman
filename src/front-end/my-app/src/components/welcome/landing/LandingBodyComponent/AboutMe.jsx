import React, { Component } from 'react';
import '../../../../css/landing/aboutme.scss'
import avatar from '../../../../css/images/download.png'

export default class AboutMe extends Component {

    constructor(props) {
        super(props)
        
        this.state = {
        }
    }

    render() {
        return (
            <div className="about_me_container">
                <div className="about_me_wrapper">
                    <div className="about_me_content">
                        <div className="about_me_avatar">
                            <img alt="my avatar" src={avatar} className="about_me_img"/>
                        </div>
                        <p className="headers about_me_headers">Nguyen Huu Hai Trung</p>
                        <p className="icon">______ <i class="fa fa-rainbow"/> ______</p>
                        <p className="about_self_title">Freelance web developer</p>
                    </div>
                </div>
            </div>
        )
    }
}