package com.proyecto.api.service;

import com.proyecto.api.model.Materia;
import java.util.List;


public interface IMateriaService {
    List<Materia> getMaterias();
    void saveMateria(Materia materia, Integer id_carrera);
    void eliminarMateria(Integer id_materia);
}
