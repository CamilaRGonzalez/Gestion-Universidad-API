package com.proyecto.api.repository;

import com.proyecto.api.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepository extends JpaRepository<Materia,Integer>{
    
}
