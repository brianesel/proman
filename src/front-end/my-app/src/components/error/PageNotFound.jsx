import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

class PageNotFound extends Component {

    constructor(props) {
        super(props)

        this.state = {
        }
    }

    render() {
        return (
            <div>ERORRR. Page not found</div>
        )
    }
}

export default PageNotFound