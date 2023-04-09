package com.proyecto.api.controller;

import com.proyecto.api.DTO.CarreraDTO;
import com.proyecto.api.DTO.CarreraMateriasDTO;
import com.proyecto.api.model.Carrera;
import com.proyecto.api.model.Materia;
import com.proyecto.api.service.ICarreraService;
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
@RequestMapping(path="/carreras")
public class CarreraController {
    @Autowired
    private ICarreraService carreraService;
    
    @GetMapping
    public List<CarreraDTO> getCarreras(){
        return carreraService.getCarreras();
    }
    
    @GetMapping(path="/materias/{id_carrera}")
    public CarreraMateriasDTO gerMaterias(@PathVariable Integer id_carrera){
        return carreraService.getMaterias(id_carrera);
    }
    
    @PostMapping ("/crear")
    public String crearCarrera(@RequestBody Carrera carrera){
        carreraService.saveCarrera(carrera);
        return "Carrera creada correctamente";         
    }
    
    @PutMapping ("/editar")
    public String editarCarrera(@RequestBody Carrera carrera) {
        carreraService.saveCarrera(carrera);
        return "Carrera editada correctamente";           
    }
    
    @DeleteMapping("/eliminar/{id_carrera}")
    public String eliminarCarrera(@PathVariable Integer id_carrera){
        carreraService.deleteCarrera(id_carrera);
        return "Registro eliminado";
    }
}
