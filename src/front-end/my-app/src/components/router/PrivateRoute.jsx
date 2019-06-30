import React, { Component } from 'react';
import { BrowserRouter as Route, Link, Router, Redirect } from "react-router-dom";
import auth from '../../js/requests/AuthenticationRequest'

export const PrivateRoute = ({ component: Component, ...rest }) => (
    <Link {...rest} render={(props) => (
      auth.isAuthenticated === true
        ? <Component {...props} />
        : <Redirect to='/login' />
    )} />
)
