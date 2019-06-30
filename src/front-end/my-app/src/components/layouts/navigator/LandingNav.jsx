import React, { Component } from 'react';
import { BrowserRouter as Route, Router, Link, NavLink } from "react-router-dom";
import SigninPage from '../../authen/LoginPage'
import SignupPage from '../../authen/SignupPage'
import UserProfile from '../../user/UserInfo'
import logo from '../../../logo.png'
import '../../../css/layouts/landingNav.scss'
import {PrivateRoute} from '../../router/PrivateRoute'

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
                    name: 'About me',
                    path: '/about',
                    component: {SignupPage}
                },
                {
                    name: 'Services',
                    path: '/services',
                    component: {SignupPage}
                },
                {
                    name: 'My account',
                    path: '/account',
                    component: {UserProfile}
                },
                {
                    name: 'Contact',
                    path: '/contact',
                    component: {SignupPage}
                }
            ]
        }
    }

    render() {
        this.menu_items = this.state.menu.map((item) =>{
            return item.path === '/account' 
            ? <PrivateRoute className="nav_link" to={item.path} component={item.component}>
                <li name={item.path}>{item.name}</li>
            </PrivateRoute>
            : <Link className="nav_link" to={item.path}>
                <li name={item.path}>{item.name}</li> 
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