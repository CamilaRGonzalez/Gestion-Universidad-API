package com.proyecto.api.repository;

import com.proyecto.api.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno,Long>{
    
}