import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class REUNIONEdit extends Component {

    emptyItem = {
        fechayhora: '',
        idreunion: '',
        descripcion: ''
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
        if (this.props.match.params.idreunion !== 'new') { // 
            const reunion = await (await fetch(`/reunions/${this.props.match.params.idreunion}`)).json();
            this.setState({item: reunion});
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

    await fetch('/reunions' + ((this.props.match.params.idreunion !== 'new') ? '/' + item.idreunion : ''), {
        method: (this.props.match.params.idreunion !== 'new') ? 'PUT' : 'POST', //(item.email) ? 'PUT' : 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item),
    });
    this.props.history.push('/reunions');
}

    render() {
        const {item} = this.state;
        const title = <h2 color = 'red'>{item.idreunion ? 'Editar reunion' : 'Añadir reunion'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="fechayhora">FECHA Y HORA</Label>
                        <Input type="datetime-local" name="fechayhora" id="fechayhora" value={item.fechayhora || ''}
                               onChange={this.handleChange} autoComplete="fechayhora"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="descripcion">Descripcion</Label>
                        <Input type="text" name="descripcion" id="descripcion" value={item.descripcion || ''}
                               onChange={this.handleChange} autoComplete="descripcion"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Guardar</Button>{' '}
                        <Button color="secondary" tag={Link} to="/reunions">Cancelar</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(REUNIONEdit);