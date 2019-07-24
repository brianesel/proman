import React, { Component } from 'react';
import '../../../../css/landing/service.scss';

export default class Services extends Component {

    constructor(props) {
        super(props)
        
        this.state = {
            services: [
                {
                    name: "Connect",
                    image: "blue",
                    description: "1"
                },
                {
                    name: "Auto craft",
                    image: "yellow",
                    description: "2"
                },
                {
                    name: "Conversion",
                    image: "pink",
                    description: "3"
                },
                {
                    name: "Exciting",
                    image: "red",
                    description: "4"
                }
            ]
        }
    }

    render() {
        this.services_items =  Object.keys(this.state.services).map((key)=>{
            return <div className="services_item_container col-3" >
                <div className="services_item" style={{backgroundColor: this.state.services[key].image}}>
                    <p className="service_title">{this.state.services[key].name}</p>
                    <p className="service_description">{this.state.services[key].description}</p>
                </div>
            </div>
        })
        return (
            <div className="services_container">
                <div className="services_wrapper">
                    <div className="services_content">
                        <p className="header">Service</p>
                        <div className="body_icon"><i className="fa fa-rainbow"/></div>
                        <div className="services_list row">
                            {this.services_items}
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}