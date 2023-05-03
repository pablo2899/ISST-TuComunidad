import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class INFOEdit extends Component {

    emptyItem = {
        tema: '',
        idinfo: '',
        contenido: '',
        vecino: ''
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
        if (this.props.match.params.idinfo !== 'new') { // 
            const info = await (await fetch(`/infos/${this.props.match.params.idinfo}`)).json();
            this.setState({item: info});
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

    await fetch('/infos' + ((this.props.match.params.idinfo !== 'new') ? '/' + item.idinfo : ''), {
        method: (this.props.match.params.idinfo !== 'new') ? 'PUT' : 'POST', //(item.email) ? 'PUT' : 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item),
    });
    this.props.history.push('/infos');
}

    render() {
        const {item} = this.state;
        const title = <h2>{item.idinfo ? 'Editar publicacion' : 'Añadir publicación'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="tema">Tema</Label>
                        <Input type="text" name="tema" id="tema" value={item.tema || ''}
                               onChange={this.handleChange} autoComplete="tema"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="contenido">Contenido</Label>
                        <Input type="text" name="contenido" id="contenido" value={item.contenido || ''}
                               onChange={this.handleChange} autoComplete="contenido"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="vecino">Vecino</Label>
                        <Input type="text" name="vecino" id="vecino" value={item.vecino || ''}
                               onChange={this.handleChange} autoComplete="vecino"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Publicar</Button>{' '}
                        <Button color="secondary" tag={Link} to="/infos">Cancelar</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(INFOEdit);