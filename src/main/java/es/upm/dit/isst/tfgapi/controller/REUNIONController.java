package es.upm.dit.isst.tfgapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.tfgapi.model.REUNION;
import es.upm.dit.isst.tfgapi.repository.REUNIONRepository;

@RestController
public class REUNIONController {

    private final REUNIONRepository reunionRepository;

    public static final Logger log = LoggerFactory.getLogger(REUNIONController.class);

    public REUNIONController(REUNIONRepository r) {

        this.reunionRepository = r;

    }

    @GetMapping("/reunions")

    List<REUNION> readAll() {

      return (List<REUNION>) reunionRepository.findAll();

    }

 

    @PostMapping("/reunions")

    ResponseEntity<REUNION> create(@RequestBody REUNION newREUNION) throws URISyntaxException {

      REUNION result = reunionRepository.save(newREUNION);

      return ResponseEntity.created(new URI("/reunions/" + result.getIdreunion())).body(result);

    }

 

    @GetMapping("/reunions/{id}")

    ResponseEntity<REUNION> read(@PathVariable String id) {

      return reunionRepository.findById(id).map(reunion ->

         ResponseEntity.ok().body(reunion)

      ).orElse(new ResponseEntity<REUNION>(HttpStatus.NOT_FOUND));

    }


    @PutMapping("/reunions/{id}")

    ResponseEntity<REUNION> update(@RequestBody REUNION newREUNION, @PathVariable String id) {

      return reunionRepository.findById(id).map(reunion -> {

        reunion.setFechayhora(newREUNION.getFechayhora());

        reunion.setDescripcion(newREUNION.getDescripcion());

        reunionRepository.save(reunion);

        return ResponseEntity.ok().body(reunion);

      }).orElse(new ResponseEntity<REUNION>(HttpStatus.NOT_FOUND));

    }


    @DeleteMapping("reunions/{id}")

    ResponseEntity<REUNION> delete(@PathVariable String id) {

      reunionRepository.deleteById(id);

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