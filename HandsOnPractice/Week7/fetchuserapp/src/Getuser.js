import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null
    };
  }

  async componentDidMount() {
    const response = await fetch('https://api.randomuser.me/');
    const data = await response.json();
    this.setState({ user: data.results[0] });
  }

  render() {
    const { user } = this.state;

    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        {user ? (
          <div>
            <h2>
              {user.name.title} {user.name.first}
            </h2>
            <img src={user.picture.large} alt="user" />
          </div>
        ) : (
          <p>Loading user data...</p>
        )}
      </div>
    );
  }
}

export default Getuser;
