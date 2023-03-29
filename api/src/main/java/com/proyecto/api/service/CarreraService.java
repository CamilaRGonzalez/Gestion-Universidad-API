package com.proyecto.api.service;

import com.proyecto.api.DTO.CarreraDTO;
import com.proyecto.api.DTO.CarreraMateriasDTO;
import com.proyecto.api.model.Carrera;
import com.proyecto.api.repository.ICarreraRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraService implements ICarreraService{
    @Autowired
    private ICarreraRepository carreraRepo;

    @Override
    public List<CarreraDTO> getCarreras() {
        List<Carrera> listaEntidad = carreraRepo.findAll();
        List<CarreraDTO> listaDTO = new ArrayList();
        for(Carrera item:listaEntidad){
            CarreraDTO carrera = new CarreraDTO();
            carrera.setId_carrera(item.getId_carrera());
            carrera.setNombre(item.getNombre());
            carrera.setDuracion(item.getDuracion());
            listaDTO.add(carrera);
        }      
        return listaDTO;
    }

    @Override
    public boolean saveCarrera(Carrera carrera) {
        try{
            carreraRepo.save(carrera);
            return true;
        }
        catch(Exception e){
            return false;
        }       
    }

    @Override
    public boolean deleteCarrera(Integer id_carrera) {
        try{
            carreraRepo.deleteById(id_carrera);
            return true;
        }
        catch(Exception e){
            return false;
        }  
    }

    @Override
    public CarreraMateriasDTO getMaterias(Integer id_carrera) {
        Carrera entidad = carreraRepo.carreraMaterias(id_carrera);
        //Carrera entidad = carreraRepo.findById(id_carrera).orElse(null);
        if(entidad !=null){
            CarreraMateriasDTO dto = new CarreraMateriasDTO();
            dto.setNombre(entidad.getNombre());
            dto.setListaMaterias(entidad.getListaMaterias());
            return dto;
        }
        return null;
    }
    
    
}
