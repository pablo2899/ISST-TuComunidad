import React, { Component } from "react";
import { Button, ButtonGroup, Container, Table } from "reactstrap";
import AppNavbar from "./AppNavbar";
import { Link } from "react-router-dom";

class RESERVAList extends Component {
  constructor(props) {
    super(props);
    this.state = { reserva: [] };
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    fetch("/reservas")
      .then((response) => response.json())
      .then((data) => this.setState({ reserva: data }));
  }

  async remove(idreserva) {
    await fetch(`/reservas/${idreserva}`, {
      method: "DELETE",
      headers: {
        'Accept': "application/json",
        'Content-Type': "application/json",
      },
    }).then(() => {
      let updatedreservas = [...this.state.reserva].filter((i) => i.idreserva !== idreserva);
      this.setState({ reserva: updatedreservas });
    });
  }
  
  render() {
    const RESERVAList = this.state.reserva.map((reserva) => {
      return (
        <tr key={reserva.idreserva}>
          <td style={{ whiteSpace: 'nowrap' }}>{reserva.idreserva}</td>
          <td>{reserva.fechayhorareservada}</td>
          <td>{reserva.espacioreservado}</td>
          <td>{reserva.estaReservado}</td>
          <td><ButtonGroup
          ><Button size="sm" color="primary" tag={Link} to={"/reservas/" + reserva.idreserva}> Edit </Button>
          <Button size="sm" color="danger" onClick={() => this.remove(reserva.idreserva)}> Delete </Button>
          </ButtonGroup> </td>
        </tr>
      );
    });

    return (
      <>
        <div>
          <AppNavbar />
          <center> <h3>RESERVAS</h3> </center>
        </div>
        <div>
          <Container fluid>
            <div className="float-right">
              <Button color="warning" tag={Link} to="/reservas/new">
                Añadir Reserva
              </Button>
            </div>

            <Table
                className="mt-4"
                style={{
                  borderBottom: "solid 3px black",
                  background: "grey",
                  color: "white",
                  fontWeight: "bold",
                }}
              >
              <thead>
                <tr>
                  <th width="30%">IdReserva</th>
                  <th width="30%">Fecha y Hora Reservada</th>
                  <th width="30%">Espacio Reservado</th>
                  <th width="30%">Esta Reservado</th>
                  
                </tr>
              </thead>
              <tbody>{RESERVAList}</tbody>
            </Table>
          </Container>
        </div>
      </>
    );
  }
}

export default RESERVAList;
