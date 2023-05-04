import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import './Home.css';
import logoComVec from './logoComVec.png';

class Home extends Component {
    render() {
        const divStyle = {
          height: "300",
          innerWidth: "300",
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
        };
        const divStyle2 = {
        
            display: "flex",
            alignItems: "space-between",
            justifyContent: "center",
            padding: "50px"
            
            
          };
          
        return (
          <div>
            <div style={divStyle}>
              <img src={logoComVec} className="logo" />
            </div>
            
            <div style={divStyle2}>
              <Button className="boton" color="warning">
                <Link to="/infos">Bienvenido vecino a TuComunidad</Link>
              </Button>
            </div>
          </div>
        );
    }
}

export default Home;