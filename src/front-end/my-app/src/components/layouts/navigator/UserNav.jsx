import React, { Component } from 'react';
import { Link } from "react-router-dom";

export default class UserNav extends Component {

    constructor(props) {
        super(props)
        
        this.state = {
            menu : [
                {
                    name:'About me',
                    path:'/myprofile'
                },
                {
                    name:'Resume',
                    path:'/myprofile/resume'
                },
                {
                    name:'Portfolio',
                    path:'/myprofile/portfolio'
                },
                {
                    name:'Contact',
                    path:'/myprofile/contact'
                }
            ]
        }
    }

    render() {
        this.menu_items = this.state.menu.map((item, index) =>{
            
            return <Link key={index} className="nav_link" to={item.path}>
                <li name={item.path}>{item.name}</li> 
            </Link> 
        })
        return (
            <div className="nav-container">
                <div className="wrapper">
                    <div className="menu-container">
                        <div className="items">
                            {this.menu_items}
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}