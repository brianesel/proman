import { BrowserRouter as Route, Link } from "react-router-dom";
import auth from '../../js/requests/AuthenticationRequest'

export const PrivateRoute = ({ component: Component, ...rest }) => (
    <Route {...rest} render={(props) => (
      auth.isAuthenticated === true
        ? <Component {...props} />
        : <Redirect to= {{
          state: {
            from: props.location
          }
        }} />
    )} />)
