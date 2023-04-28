package com.proyecto.api.service;

import com.proyecto.api.model.Alumno;
import com.proyecto.api.model.Materia;
import java.util.List;


public interface IAlumnoService {
    List<Alumno> alumnosPorCarrera(Integer id_carrera);
    String carreraCursada(Integer id_alumno);
    List<Materia> materiasPorAlumno(Integer id_alumno);
    void eliminarMateria(Integer id_materia, Long id_alumno);
    void saveAlumno(Alumno alumno);
    void eliminarAlumno(Integer id_alumno);
    void agregarMateria(Integer id_materia, Long id_alumno);
}
