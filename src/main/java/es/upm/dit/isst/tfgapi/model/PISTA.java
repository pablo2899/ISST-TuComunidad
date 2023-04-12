package es.upm.dit.isst.tfgapi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.JoinColumn;

@Entity
public class PISTA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idpista;

        @ManyToOne (fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "idcomunidad", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        private COMUNIDAD comunidad;

    public PISTA () { }
    

    public PISTA(String idpista, COMUNIDAD comunidad) {
        this.idpista = idpista;
        this.comunidad = comunidad;
    }
    public COMUNIDAD getComunidad() {
        return comunidad;
    }

    public void setComunidad(COMUNIDAD comunidad) {
        this.comunidad = comunidad;
    }
    public String getIdpista() {
        return idpista;
    }
    public void setIdpista(String idpista) {
        this.idpista = idpista;
    }

    
}
