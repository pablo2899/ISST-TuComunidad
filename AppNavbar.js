import React, {Component} from 'react';
import {Navbar, NavbarBrand, NavLink} from 'reactstrap';
import {Link} from 'react-router-dom';
import { Button} from 'reactstrap';

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }
    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }
    
    
    render() {
        return <Navbar color="light" secondary expand="md">

            

            <Button color="warning"><Link to="/login">Cerrar Sesion</Link></Button>
            <Button color="succesful"><Link to="/">HOME</Link></Button>
            <Button color="Link"><Link to="/infos">TABLON DE INFORMACIÓN</Link></Button>
            <Button color="Link"><Link to="/reunions">REUNIONES</Link></Button>
            <Button color="Link"><Link to="/votacions">VOTACIONES</Link></Button>
            <Button color="Link"><Link to="/reservas">RESERVAS</Link></Button>

        </Navbar>;
    }
}