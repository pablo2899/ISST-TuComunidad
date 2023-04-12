package es.upm.dit.isst.tfgapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RESERVA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idreserva;
    private String fechayhora;
    private Boolean estaReservada;

    public RESERVA () { }
    public RESERVA(String idreserva, String fechayhora, Boolean estaReservada) {
        this.idreserva = idreserva;
        this.fechayhora = fechayhora;
        this.estaReservada = estaReservada;
    }
    public String getIdreserva() {
        return idreserva;
    }
    public void setIdreserva(String idreserva) {
        this.idreserva = idreserva;
    }
    public String getFechayhora() {
        return fechayhora;
    }
    public void setFechayhora(String fechayhora) {
        this.fechayhora = fechayhora;
    }
    public Boolean getEstaReservada() {
        return estaReservada;
    }
    public void setEstaReservada(Boolean estaReservada) {
        this.estaReservada = estaReservada;
    }
}
