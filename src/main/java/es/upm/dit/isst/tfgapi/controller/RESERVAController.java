package es.upm.dit.isst.tfgapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.tfgapi.model.RESERVA;
import es.upm.dit.isst.tfgapi.repository.RESERVARepository;

@RestController
public class RESERVAController {

    private final RESERVARepository reservaRepository;

    public static final Logger log = LoggerFactory.getLogger(RESERVAController.class);

    public RESERVAController(RESERVARepository i) {

        this.reservaRepository = i;

    }

    

    @GetMapping("/reservas")

    List<RESERVA> readAll() {

      return (List<RESERVA>) reservaRepository.findAll();

    }

 
    
    @PostMapping("/reservas")

    ResponseEntity<RESERVA> create(@RequestBody RESERVA newReserva) throws URISyntaxException {

      RESERVA result = reservaRepository.save(newReserva);

      return ResponseEntity.created(new URI("/reservas/" + result.getIdreserva())).body(result);

    }

 
    

    @GetMapping("/reservas/{id}")

    ResponseEntity<RESERVA> read(@PathVariable String id) {

      return reservaRepository.findById(id).map(info ->

         ResponseEntity.ok().body(info)

      ).orElse(new ResponseEntity<RESERVA>(HttpStatus.NOT_FOUND));

    }

    

    @PutMapping("/reservas/{id}")

    ResponseEntity<RESERVA> update(@RequestBody RESERVA newRESERVA, @PathVariable String id) {

      return reservaRepository.findById(id).map(reserva -> {

        reserva.setEstaReservada(newRESERVA.getEstaReservada());

        reserva.setFechayhora(newRESERVA.getFechayhora());

        reserva.setIdreserva(newRESERVA.getIdreserva());

        reserva.setEspacioreservado(newRESERVA.getEspacioreservado());

        reservaRepository.save(reserva);

        return ResponseEntity.ok().body(reserva);

      }).orElse(new ResponseEntity<RESERVA>(HttpStatus.NOT_FOUND));

    }

    

    @DeleteMapping("reservas/{id}")

    ResponseEntity<RESERVA> delete(@PathVariable String id) {

      reservaRepository.deleteById(id);

      return ResponseEntity.ok().body(null);

    }
}