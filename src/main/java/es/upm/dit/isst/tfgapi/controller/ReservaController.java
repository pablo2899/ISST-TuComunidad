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
public class ReservaController {

    private final RESERVARepository RESERVARepository;

    public static final Logger log = LoggerFactory.getLogger(ReservaController.class);

    public ReservaController(RESERVARepository i) {

        this.RESERVARepository = i;

    }

    

    @GetMapping("/reservas")

    List<RESERVA> readAll() {

      return (List<RESERVA>) RESERVARepository.findAll();

    }

 
    
    @PostMapping("/reservas")

    ResponseEntity<RESERVA> create(@RequestBody RESERVA newReserva) throws URISyntaxException {

      RESERVA result = RESERVARepository.save(newReserva);

      return ResponseEntity.created(new URI("/reservas/" + result.getIdreserva())).body(result);

    }

 
    

    @GetMapping("/reservas/{id}")

    ResponseEntity<RESERVA> read(@PathVariable String id) {

      return RESERVARepository.findById(id).map(info ->

         ResponseEntity.ok().body(info)

      ).orElse(new ResponseEntity<RESERVA>(HttpStatus.NOT_FOUND));

    }

    

    @PutMapping("/reservas/{id}")

    ResponseEntity<RESERVA> update(@RequestBody RESERVA newRESERVA, @PathVariable String id) {

      return RESERVARepository.findById(id).map(info -> {

        info.setEstaReservada(newRESERVA.getEstaReservada());

        info.setFechayhora(newRESERVA.getFechayhora());

        info.setIdreserva(newRESERVA.getIdreserva());

        RESERVARepository.save(info);

        return ResponseEntity.ok().body(info);

      }).orElse(new ResponseEntity<RESERVA>(HttpStatus.NOT_FOUND));

    }

    

    @DeleteMapping("reservas/{id}")

    ResponseEntity<RESERVA> delete(@PathVariable String id) {

      RESERVARepository.deleteById(id);

      return ResponseEntity.ok().body(null);

    }


    /*@GetMapping("/tfgs/profesor/{id}")

    List<TFG> readTutor(@PathVariable String id) {

      return (List<TFG>) tfgRepository.findByTutor(id);

    }*/


    /*@PostMapping("/tfgs/{id}/incrementa")

    ResponseEntity<TFG> incrementa(@PathVariable String id) {

      return tfgRepository.findById(id).map(tfg -> {

       tfg.setStatus(tfg.getStatus() + 1);

        tfgRepository.save(tfg);

        return ResponseEntity.ok().body(tfg);

      }).orElse(new ResponseEntity<TFG>(HttpStatus.NOT_FOUND));  

    }*/

}