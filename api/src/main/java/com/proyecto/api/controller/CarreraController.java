package com.proyecto.api.controller;

import com.proyecto.api.DTO.CarreraDTO;
import com.proyecto.api.DTO.CarreraMateriasDTO;
import com.proyecto.api.model.Carrera;
import com.proyecto.api.service.ICarreraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping(path="/materias")
    public CarreraMateriasDTO gerMaterias(){
        return carreraService.getMaterias(1);
    }
}
