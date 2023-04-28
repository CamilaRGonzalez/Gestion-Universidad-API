package com.proyecto.api.service;

import com.proyecto.api.model.Alumno;
import com.proyecto.api.model.Materia;
import com.proyecto.api.repository.IAlumnoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlumnoService implements IAlumnoService{
    @Autowired
    private IAlumnoRepository alumnoRepo;
    @Autowired
    private IMateriaService materiaService;

    @Override
    public List<Alumno> alumnosPorCarrera(Integer id_carrera) {
        return alumnoRepo.alumnosPorCarrera(id_carrera);
    }

    @Override
    public String carreraCursada(Integer id_alumno) {
        return alumnoRepo.carreraAlumno(id_alumno);
    }

    @Override
    public List<Materia> materiasPorAlumno(Integer id_alumno) {
        Alumno alumno = alumnoRepo.materiasPorAlumno(id_alumno);
        return alumno.getListaMateriasAlumno();
    }

    @Override
    public void eliminarMateria(Integer id_materia, Long id_alumno) {
        Alumno alumno = alumnoRepo.findById(id_alumno).orElse(null);
        List<Materia> materias = alumno.getListaMateriasAlumno();
        Materia materia = (Materia)materias.stream().filter(mat -> mat.getId_materia() == id_materia);
        materias.remove(materia);
        alumno.setListaMateriasAlumno(materias);
    }

    @Override
    public void saveAlumno(Alumno alumno) {
        alumnoRepo.save(alumno);
    }

    @Override
    public void eliminarAlumno(Integer id_alumno) {
        alumnoRepo.deleteById(id_alumno.longValue());
    }

    @Override
    public void agregarMateria(Integer id_materia, Long id_alumno) {
        Alumno alumno = alumnoRepo.findById(id_alumno).orElse(null);
        List<Materia> materias = alumno.getListaMateriasAlumno();
        Materia materia = materiaService.getMateria(id_materia);
        materias.add(materia);
        alumno.setListaMateriasAlumno(materias);
    }
}
