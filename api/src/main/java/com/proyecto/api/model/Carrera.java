package com.proyecto.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_carrera;
    private String nombre;
    private Integer duracion;
    
    @OneToMany(mappedBy="carrera_materia")
    private List<Materia> listaMaterias;
    
    @OneToMany(mappedBy="carrera_alumno")
    private List<Alumno> listaAlumnos;
    
    public Carrera() {
    }

    public Carrera(Integer id_carrera, String nombre, Integer duracion) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.duracion = duracion;
    }
      
    @Override
    public String toString() {
        return "Carrera{" + "id_carrera=" + id_carrera + ", nombre=" + nombre + ", duracion=" + duracion + '}';
    }
      
}
