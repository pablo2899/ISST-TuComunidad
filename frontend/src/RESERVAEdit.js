import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class RESERVAEdit extends Component {

    emptyItem = {
        fechayhora: '',
        idreserva: '',
        espacioreservado: '',
        estaReservada: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.idreserva !== 'new') { // 
            const reserva = await (await fetch(`/reservas/${this.props.match.params.idreserva}`)).json();
            this.setState({item: reserva});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;

    await fetch('/reservas' + ((this.props.match.params.idreserva !== 'new') ? '/' + item.idreserva : ''), {
        method: (this.props.match.params.idreserva !== 'new') ? 'PUT' : 'POST', //(item.email) ? 'PUT' : 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item),
    });
    this.props.history.push('/reservas');
}

    render() {
        const {item} = this.state;
        const title = <h2>{item.idreserva ? 'Editar reserva' : 'Añadir reserva'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="fechayhora">FECHA Y HORA RESERVADA</Label>
                        <Input type="datetime-local" name="fechayhora" id="fechayhora" value={item.fechayhora || ''}
                               onChange={this.handleChange} autoComplete="fechayhora"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="espacioreservado">ESPACIO RESERVADO</Label>
                        <Input type="checkbox" name="espacioreservado" id="espacioreservado" value={item.espacioreservado = 'Pista Padel 1'}
                               onChange={this.handleChange} autoComplete="espacioreservado"/>
                        <label for='espacio reservado'>Pista Padel 1</label>
                        <Input type="checkbox" name="espacioreservado" id="espacioreservado" value={item.espacioreservado = 'Pista Padel 2'}
                               onChange={this.handleChange} autoComplete="espacioreservado"/>
                        <label for='espacio reservado'>Pista Padel 2</label>
                        <Input type="checkbox" name="espacioreservado" id="espacioreservado" value={item.espacioreservado = 'Pista Padel 3'}
                               onChange={this.handleChange} autoComplete="espacioreservado"/>
                        <label for='espacio reservado'>Pista Padel 3</label>
                    </FormGroup>
                    <FormGroup>
                        <Label for = "estaReservada"> ¿Reservado? </Label>
                        <Input type="checkbox" name="estaReservada" id="estaReservada" value={item.espacioreservado = true}
                               onChange={this.handleChange} autoComplete="estaReservada"/>
                        <label for='estaReservada'>Reservar</label>
                        <Input type="checkbox" name="estaReservada" id="estaReservada" value={item.espacioreservado = false}
                               onChange={this.handleChange} autoComplete="estaReservada"/>
                        <label for='estaReservada'>No reservar</label>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Guardar</Button>{' '}
                        <Button color="secondary" tag={Link} to="/reservas">Cancelar</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(RESERVAEdit);