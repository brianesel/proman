import React, { Component } from 'react';
import '../../../css/landing/footer.scss'

export default class LandingFooter extends Component {

    constructor(props) {
        super(props)
        
        this.state = {
        }
    }

    render() {
        return (
            <div className="footer_container">
                <div className="footer_wrapper">
                    <div className="footer_content row">
                        <section className="location col-4">
                            <p className="header">Location</p>
                            <p className="text_content">Earth, Solar System, Milkyway, The knowned Universe</p>
                        </section>
                        <section className="social_media col-4">
                            <p className="header">Find me on</p>
                            <p className="text_content social_media_content">
                                <a className="social_profile_link" href="https://www.linkedin.com/in/trung-nguyen-huu-hai-a0a111184/"><i className="fab fa-facebook"/></a>
                                <a className="social_profile_link" href="https://www.linkedin.com/in/trung-nguyen-huu-hai-a0a111184/"><i className="fab fa-twitter"/></a>
                                <a className="social_profile_link" href="https://www.linkedin.com/in/trung-nguyen-huu-hai-a0a111184/"><i className="fab fa-linkedin"/></a>
                                <a className="social_profile_link" href="https://github.com/brianesel"><i className="fab fa-github"/></a>
                            </p>
                        </section>
                        <section className="about_app col-4">
                            <p className="header">About Proman</p>  
                            <p className="text_content">It is what it is :)</p>
                        </section>
                    </div>
                </div>
            </div>
        )
    }
}

