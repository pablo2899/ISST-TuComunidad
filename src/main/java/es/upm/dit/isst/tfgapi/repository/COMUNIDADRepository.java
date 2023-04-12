package es.upm.dit.isst.tfgapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.tfgapi.model.COMUNIDAD;

public interface COMUNIDADRepository extends CrudRepository<COMUNIDAD, String> {

   Optional<COMUNIDAD> findById(String id);
   // List<COMUNIDAD> findById(String tutor);

}
