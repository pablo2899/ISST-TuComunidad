package es.upm.dit.isst.tfgapi.repository;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.tfgapi.model.RESERVA;

public interface RESERVARepository extends CrudRepository<RESERVA, String> {

   // List<TFG> findByTutor(String tutor);

}
