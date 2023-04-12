package es.upm.dit.isst.tfgapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class INFO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idinfo;
    private String tema;
    private String contenido;
    private String vecino;
    public INFO(String idinfo, String tema, String contenido, String vecino) {
        this.idinfo = idinfo;
        this.tema = tema;
        this.contenido = contenido;
        this.vecino = vecino;
    }
    public INFO () { }
    public String getIdinfo() {
        return idinfo;
    }
    public void setId(String idinfo) {
        this.idinfo = idinfo;
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public String getVecino() {
        return vecino;
    }
    public void setVecino(String vecino) {
        this.vecino = vecino;
    }
    
    
    
    
    
    
}
