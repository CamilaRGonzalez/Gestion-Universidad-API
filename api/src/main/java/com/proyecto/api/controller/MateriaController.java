package com.proyecto.api.controller;

import com.proyecto.api.model.Materia;
import com.proyecto.api.service.IMateriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/materias")
public class MateriaController {
    @Autowired
    private IMateriaService materiaService;
    
    @GetMapping
    public List<Materia> getMaterias(){
        return materiaService.getMaterias();
    }
    
    @PostMapping ("/crear/{id_carrera}")
    public String createMateria(@RequestBody Materia materia,@PathVariable Integer id_carrera){
        materiaService.saveMateria(materia, id_carrera);
        return "Materia creada correctamente";         
    }
    
    @PutMapping ("/editar")
    public String editarMateria(@RequestBody Materia materia,@PathVariable Integer id_carrera) {
        materiaService.saveMateria(materia, id_carrera);
        return "Materia editada correctamente";           
    }
    
    @DeleteMapping("/eliminar/{id_materia}")
    public String eliminarMateria(@PathVariable Integer id_materia){
        materiaService.eliminarMateria(id_materia);
        return "Registro eliminado";
    }
}
