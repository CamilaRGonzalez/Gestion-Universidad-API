package com.proyecto.api.service;

import com.proyecto.api.DTO.CarreraDTO;
import com.proyecto.api.DTO.CarreraMateriasDTO;
import com.proyecto.api.model.Carrera;
import java.util.List;


public interface ICarreraService {
    public List<CarreraDTO> getCarreras();
    public CarreraMateriasDTO getMaterias(Integer id_carrera);
    public boolean saveCarrera(Carrera carrera);
    public boolean deleteCarrera(Integer id_carrera);
}
