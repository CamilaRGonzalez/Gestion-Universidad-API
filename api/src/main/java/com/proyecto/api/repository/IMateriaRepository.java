package com.proyecto.api.repository;

import com.proyecto.api.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepository extends JpaRepository<Materia,Integer>{
    @Query(value="SELECT COUNT(id_materia) FROM Materia m WHERE m.fk_carrera=:id", 
    nativeQuery = true)
    long contarMaterias(@Param("id") Integer id);
}
