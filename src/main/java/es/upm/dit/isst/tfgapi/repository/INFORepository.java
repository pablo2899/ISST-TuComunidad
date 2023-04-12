package es.upm.dit.isst.tfgapi.repository;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.tfgapi.model.INFO;

public interface INFORepository extends CrudRepository<INFO, String> {

   // List<TFG> findByTutor(String tutor);

}
