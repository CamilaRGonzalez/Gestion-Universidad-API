package com.proyecto.api.service;

import com.proyecto.api.model.Carrera;
import com.proyecto.api.model.Materia;
import com.proyecto.api.repository.IMateriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MateriaService implements IMateriaService{
    
    @Autowired
    private IMateriaRepository repoMateria;
    
    @Override
    public List<Materia> getMaterias() {
        return repoMateria.findAll();
    }

    @Override
    public void saveMateria(Materia materia, Integer id_carrera) {
        Carrera carrera = new Carrera();
        //creo un objeto carrera y le seteo el id segun la carrera que corresponde
        carrera.setId_carrera(id_carrera);
        //a mi objeto materia recibido por parametro le seteo el objeto carrera
        materia.setCarrera_materia(carrera);
        repoMateria.save(materia);
    }

    @Override
    public void eliminarMateria(Integer id_materia) {
        repoMateria.deleteById(id_materia);
    }

    @Override
    public Long contarMateriasPorCarrera(Integer fk_carrera) {
        return repoMateria.contarMaterias(fk_carrera);
        //return 1L;
    }
    
}
