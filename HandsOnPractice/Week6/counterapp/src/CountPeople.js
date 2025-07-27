import React from 'react';

class CountPeople extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div style={{ padding: "20px", textAlign: "center" }}>
        <h2>People Counter</h2>
        <p><strong>Entered:</strong> {this.state.entrycount}</p>
        <p><strong>Exited:</strong> {this.state.exitcount}</p>
        <button onClick={this.updateEntry} style={{ margin: "10px" }}>Login</button>
        <button onClick={this.updateExit} style={{ margin: "10px" }}>Exit</button>
      </div>
    );
  }
}

export default CountPeople;
