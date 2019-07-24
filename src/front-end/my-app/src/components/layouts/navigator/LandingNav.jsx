import React, { Component } from 'react';
import { Link } from "react-router-dom";
import SignupPage from '../../authen/SignupPage'
import UserDashboard from '../../user/UserDashboard'
import logo from '../../../logo.png'
import '../../../css/layouts/landingNav.scss'

class LandingMenu extends Component {

    constructor(props) {
        super(props)

        this.state = {
            menu: [
                {
                    name: 'Home',
                    path: '/landing',
                    component: {SignupPage}
                },
                {
                    name: 'About App',
                    path: '/landing/about',
                    component: {SignupPage}
                },
                {
                    name: 'Services',
                    path: '/landing/services',
                    component: {SignupPage}
                },
                {
                    name: 'My account',
                    path: '/user',
                    component: {UserDashboard}
                },
                {
                    name: 'Contact',
                    path: '/landing/contact',
                    component: {SignupPage}
                }
            ]
        }
    }

    render() {
        this.menu_items = this.state.menu.map((item, index) =>{
            return item.path === '/user' 
            ? <Link key={index} className="nav_link" to={item.path} component={item.component}>
                {item.name}
            </Link>
            : <Link key={index} className="nav_link" to={item.path}>
                {item.name} 
            </Link> 
        })
        return (
            <div className="nav-container">
                <div className="wrapper">
                    <div className="branding">
                        <img className="brand_logo" src={logo} alt="It is just a logo. Yes big deal."/>
                        <p className="brand_text">Pro Man</p>
                    </div>
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

export default LandingMenu