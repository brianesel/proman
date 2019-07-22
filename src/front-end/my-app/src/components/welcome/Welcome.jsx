import React, { Component } from 'react'

const welcomepageWrapperStyle = {
        height: '100%',
        width: '100%',
        minWidth: '700px',
        position: 'absolute',
        bottom: '0',
        left: '0',
        display: 'block',
        opacity: '0.8',
        backgroundColor: 'blue',
        backgroundImage: 'linear-gradient(-169deg,#00d6bd 2%,#42e6f5 35%, red)',
        zIndex: '1'
    }

const welcomeTextWrapperStyle = {
        position: 'absolute',
        left: '48.5%',
        top: '50%',
        transform: 'translate(-50%, -50%)',
        width: '850px',
        height: '350px',
        zIndex: '100',
        textDecoration: 'none'
    }

const upperTextStyle = {
    position: 'absolute',
    left: '50%',
    top: '38%',
    transform: 'translate(-50%,-50%)',
    fontSize: '150px',
    fontWeight: '900',
    color: '#bf1d58'
}

const textWelcomeStyle = {
    position: 'absolute',
    display: 'inline-block',
    left: '51.5%',
    top: '40%',
    transform: 'translate(-50%,-50%)',
    fontSize: '150px',
    fontWeight: '900',
    color: '#bf1d58'
}

class Welcome extends Component {

    constructor(props) {
        super(props)
        
        this.state = {
        }
    }

    render() {
        return (
            <div className="welcomePage_wrapper" style={welcomepageWrapperStyle}>
                <a href="/landing" style={welcomeTextWrapperStyle}>
                    <div className="upper-text" style={upperTextStyle}>WELCOME</div>
                    <div className="text" style={textWelcomeStyle}>WELCOME</div>
                </a>
            </div>
        )
    }
}

export default Welcome