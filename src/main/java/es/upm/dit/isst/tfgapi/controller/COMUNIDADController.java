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

import es.upm.dit.isst.tfgapi.model.COMUNIDAD;
import es.upm.dit.isst.tfgapi.repository.COMUNIDADRepository;

@RestController
public class COMUNIDADController {

    private final COMUNIDADRepository comunidadRepository;

    public static final Logger log = LoggerFactory.getLogger(COMUNIDADController.class);

    public COMUNIDADController(COMUNIDADRepository i) {

        this.comunidadRepository = i;

    }

    @GetMapping("/comunidads")

    List<COMUNIDAD> readAll() {

      return (List<COMUNIDAD>) comunidadRepository.findAll();

    }


    @PostMapping("/comunidads")

    ResponseEntity<COMUNIDAD> create(@RequestBody COMUNIDAD newCOMUNIDAD) throws URISyntaxException {

      COMUNIDAD result = comunidadRepository.save(newCOMUNIDAD);

      return ResponseEntity.created(new URI("/comunidads/" + result.getId())).body(result);

    }

 

    @GetMapping("/comunidads/{id}")

    ResponseEntity<COMUNIDAD> read(@PathVariable String id) {

      return comunidadRepository.findById(id).map(info ->

         ResponseEntity.ok().body(info)

      ).orElse(new ResponseEntity<COMUNIDAD>(HttpStatus.NOT_FOUND));

  
    }
/*
    @PutMapping("/infos/{id}")

    ResponseEntity<INFO> update(@RequestBody INFO newINFO, @PathVariable String id) {

      return infoRepository.findById(id).map(info -> {

        info.setTema(newINFO.getTema());

        info.setContenido(newINFO.getContenido());

        info.setVecino(newINFO.getVecino());

        infoRepository.save(info);

        return ResponseEntity.ok().body(info);

      }).orElse(new ResponseEntity<INFO>(HttpStatus.NOT_FOUND));

    }


    @DeleteMapping("comunidad/{id}")

    ResponseEntity<COMUNIDAD> delete(@PathVariable String id) {

      comunidadRepository.deleteById(id);

      return ResponseEntity.ok().body(null);

    }

/*
    @GetMapping("/tfgs/profesor/{id}")

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