package es.upm.dit.isst.tfgapi.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class COMUNIDAD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nombre;

    //esto lo hace mas lento, es mejor implementar esto de manera manual.
    /*@OneToMany(mappedBy = "comunidad")
    List<VECINO> vecinoList;*/ 
    public COMUNIDAD () { }
    
    public COMUNIDAD(String nombre) {
        
        this.nombre = nombre;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
