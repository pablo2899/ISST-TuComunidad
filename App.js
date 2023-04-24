import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import INFOList from './INFOList';
import INFOEdit from './INFOEdit';
import REUNIONList from './REUNIONList';
import REUNIONEdit from './REUNIONEdit';
import VOTACIONList from './VOTACIONList';
import RESERVAList from './RESERVAList';
import VOTACIONEdit from './VOTACIONEdit';
import RESERVAEdit from './RESERVAEdit';

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/infos' exact={true} component={INFOList}/>
            <Route path='/infos/:idinfo' component={INFOEdit}/>
            <Route path='/reunions' exact={true} component={REUNIONList}/>
            <Route path='/reunions/:idreunion' component={REUNIONEdit}/>
            <Route path='/votacions' exact={true} component={VOTACIONList}/>
            <Route path='/votacions/:idvotacion' component={VOTACIONEdit}/>
            <Route path='/reservas' exact={true} component={RESERVAList}/>
            <Route path='/reservas/:idreserva' exact={true} component={RESERVAEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;