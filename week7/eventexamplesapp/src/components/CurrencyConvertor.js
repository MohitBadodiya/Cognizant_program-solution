import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euro: ''
    };
  }

  handleChange = (event) => {
    this.setState({ rupees: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const euroValue = (this.state.rupees / 90).toFixed(2);
    this.setState({ euro: euroValue });
  };

  render() {
    return (
      <div>
        <h2>Currency Converter</h2>
        <input type="text" value={this.state.rupees} onChange={this.handleChange} placeholder="Enter Rupees" />
        <button onClick={this.handleSubmit}>Convert</button>
        {this.state.euro && <p>Euro: €{this.state.euro}</p>}
      </div>
    );
  }
}

export default CurrencyConvertor;
