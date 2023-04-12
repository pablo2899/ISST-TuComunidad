package es.upm.dit.isst.tfgapi.repository;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.tfgapi.model.REUNION;

public interface REUNIONRepository extends CrudRepository<REUNION, String> {

   /* PARA EL FUTURO: FINDBYDAY O ALGO DEL ESTILO
   List<TFG> findByTutor(String tutor);*/

}