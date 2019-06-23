import React from 'react';
import axios from 'axios';

export default class login extends React.Component {
  state = {
    username: '',
    password: ''
  }

  handleChange = event => {
    this.setState({ name: event.target.value });
  }

  handleSubmit = event => {
    event.preventDefault();

    const user = {
      username: this.state.username,
      password: this.state.password
    };

    axios.get(`https:localhost:1609/user`, {
      auth: {
        username: user.username,
        password: user.password
      }
     })
      .then(res => {
        console.log(res);
        console.log(res.data);
      })
  }

  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <button type="submit">Add</button>
        </form>
      </div>
    )
  }
}