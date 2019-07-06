import React from 'react';
import { Route, Redirect } from "react-router-dom";
import auth from '../../js/requests/AuthenticationRequest'

export const ProtectedRoute = ({ component: Component, ...rest }) => {
  console.log(auth.isAuthenticated);
  return <Route {...rest} render={(props) => (
    auth.isAuthenticated ===true
        ? <Component {...props} />
        : <Redirect to='/signin' />
      )} />
}
  