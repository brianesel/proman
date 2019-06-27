import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

class LandingPage extends Component {

    constructor(props) {
        super(props)
        console.log("landing")
        this.state = {
        }
    }

    render() {
        return (
            <div>Hello</div>
        )
    }
}

export default LandingPage