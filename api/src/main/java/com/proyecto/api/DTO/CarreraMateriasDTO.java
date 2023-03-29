package com.proyecto.api.DTO;

import com.proyecto.api.model.Materia;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarreraMateriasDTO {
    private String nombre;
    private List<Materia> listaMaterias;

    @Override
    public String toString() {
        return "CarreraMateriasDTO{" + "nombre=" + nombre + ", listaMaterias=" + listaMaterias + '}';
    }
    
    
}
