import React from 'react';
import './App.css';
import axios from 'axios'


export default class App extends React.Component{
  state = {
    username: 'bot@gmail.com',
    password: '123123'
  }

  handleChange = event => {
    this.setState({ username: event.target.value });
  }

  handleSubmit = event => {
    event.preventDefault();
    function createBasicAuthToken(username, password) {
      return 'Basic ' + window.btoa(username + ":" + password)
    }
    const user = {
      username: this.state.username,
      password: this.state.password
    };
    console.log('sending');
    axios.get(`http://localhost:1609/login`, { headers: { authorization: createBasicAuthToken(user.username, user.password) } })
      .then(res => {
        console.log(res);
        console.log(res.data);
      })
      .then( console.log('done')
      )
  }

  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <div>
            Username:
            <input type="text" name="name" value={this.state.password} onChange={this.handleChange} />
          </div>
          <div>
            Password:
            <input type="text" name="name" value={this.state.password} onChange={this.handleChange} />
          </div>
          <button type="submit">Add</button>
        </form>
      </div>
    )
  }
} 
