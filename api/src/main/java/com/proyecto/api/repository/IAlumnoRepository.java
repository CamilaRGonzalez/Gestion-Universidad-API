package com.proyecto.api.repository;

import com.proyecto.api.model.Alumno;
import com.proyecto.api.model.Carrera;
import com.proyecto.api.model.Materia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno,Long>{
    @Query(value="select c.nombre from carrera c inner join alumno a on a.fk_carrera = c.id_carrera " +
     "where a.id_alumno = :id;",nativeQuery=true)
    String carreraAlumno(@Param("id") Integer id);
    
    @Query(value="select * from alumno a where a.id_alumno= :id",nativeQuery=true)
    List<Alumno> alumnosPorCarrera(@Param("id") Integer id);
    
    @Query("SELECT a FROM Alumno a JOIN FETCH a.listaMateriasAlumno where a.id_alumno= :id_alumno")
    Alumno materiasPorAlumno(@Param("id_alumno")Integer id_alumno);
    
}
