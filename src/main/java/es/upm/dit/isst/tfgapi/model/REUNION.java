package es.upm.dit.isst.tfgapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class REUNION {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idreunion;
    private String fechayhora;
    private String descripcion;
    public REUNION(String idreunion, String fechayhora, String descripcion) {
        this.idreunion = idreunion;
        this.fechayhora = fechayhora;
        this.descripcion = descripcion;
    }
    public REUNION () { }
    public String getIdreunion() {
        return idreunion;
    }
    public void setIdreunion(String idreunion) {
        this.idreunion = idreunion;
    }
    public String getFechayhora() {
        return fechayhora;
    }
    public void setFechayhora(String fechayhora) {
        this.fechayhora = fechayhora;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
