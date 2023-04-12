package es.upm.dit.isst.tfgapi.repository;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.tfgapi.model.PISTA;

public interface PISTARepository extends CrudRepository<PISTA, String> {

   // List<TFG> findByTutor(String tutor);

}
