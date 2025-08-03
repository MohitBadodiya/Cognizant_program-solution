import React, { Component } from 'react';
import CurrencyConvertor from './components/CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello();
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayHello = () => {
    console.log('Hello! This is a static message.');
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  handleSyntheticEvent = (event) => {
    alert('I was clicked');
    console.log(event);
  };

  render() {
    return (
      <div>
        <h1>Event Examples App</h1>

        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>

        <br/><br/>
        <button onClick={() => this.sayWelcome('Welcome to React Events')}>Say Welcome</button>

        <br/><br/>
        <button onClick={this.handleSyntheticEvent}>OnPress</button>

        <br/><br/>
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
