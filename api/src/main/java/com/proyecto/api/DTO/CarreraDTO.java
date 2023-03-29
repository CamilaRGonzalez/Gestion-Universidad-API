package com.proyecto.api.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CarreraDTO {
    private Integer id_carrera;
    private String nombre;
    private Integer duracion;

    @Override
    public String toString() {
        return "CarreraDTO{" + "id_carrera=" + id_carrera + ", nombre=" + nombre + ", duracion=" + duracion + '}';
    }
        
}
