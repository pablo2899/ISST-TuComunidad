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
    private String espacioreservado;
    private Boolean estaReservada;

    public RESERVA () { }
    public RESERVA(String idreserva, String fechayhora,String espacioreservado, Boolean estaReservada) {
        this.idreserva = idreserva;
        this.fechayhora = fechayhora;
        this.espacioreservado = espacioreservado;
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
    public String getEspacioreservado() {
        return espacioreservado;
    }
    public void setEspacioreservado(String espacioreservado) {
        this.espacioreservado = espacioreservado;
    }
    public Boolean getEstaReservada() {
        return estaReservada;
    }
    public void setEstaReservada(Boolean estaReservada) {
        this.estaReservada = estaReservada;
    }
}
