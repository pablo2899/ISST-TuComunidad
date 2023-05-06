package es.upm.dit.isst.tfgapi;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


import java.util.Optional;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import es.upm.dit.isst.tfgapi.model.RESERVA;

import es.upm.dit.isst.tfgapi.repository.RESERVARepository;



@SpringBootTest

public class Test {

 

    @Autowired

    private RESERVARepository repo;

 

    @Test

    final void testReserva() {

       

        RESERVA reserva = new RESERVA();

        reserva.setIdreserva("1");

        reserva.setFechayhora("Prueba");

        reserva.setEspacioreservado("Prueba");

        reserva.setEstaReservada("true");

       

        repo.save(reserva);


        Optional<RESERVA> reserva2 = repo.findById("1");

        assertEquals(reserva2.get().getIdreserva(), reserva.getIdreserva());

        assertEquals(reserva2.get().getEspacioreservado(), "Prueba");

       

        reserva.setEspacioreservado("Prueba2");

        repo.save(reserva);

        reserva2 = repo.findById("1");

        assertNotEquals(reserva2.get().getEspacioreservado(), "Prueba3");

               

        repo.delete(reserva);

        reserva2 = repo.findById("1");

        assertFalse(reserva2.isPresent());


    }

}