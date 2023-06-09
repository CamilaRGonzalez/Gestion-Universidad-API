package com.proyecto.api.repository;

import com.proyecto.api.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarreraRepository extends JpaRepository<Carrera,Integer>{
    
    /* 
    Join Fetch trae registros (objetos) de otras tablas pertenecientes al objeto de la tabla del select.
    Esto no se puede hacer con find all porque el fetch type es lazy, por lo cual no trae los registros
    asociados a otras tablas.
    */
    @Query("SELECT c FROM Carrera c JOIN FETCH c.listaMaterias where c.id_carrera= :id_carrera")
    Carrera carreraMaterias(@Param("id_carrera")Integer id_carrera);

}
