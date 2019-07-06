import React from 'react';
import { Route, Redirect } from "react-router-dom";
import auth from '../../js/requests/AuthenticationRequest'

export const RedirectedRoute = ({ component: Component, ...rest }) => {
  return(
    <Route {...rest} render={(props) => (
      auth.checkUserLoggedin() === false
        ? <Component {...props} />
        : <Redirect to='/myprofile' />
    )} />
)}