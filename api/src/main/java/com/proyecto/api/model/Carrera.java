package com.proyecto.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    
    @OneToMany(mappedBy="carrera_materia",fetch= FetchType.LAZY)
    //@JsonIgnore
    @JsonManagedReference
    private List<Materia> listaMaterias;
    
    //@JsonIgnore
    @OneToMany(mappedBy="carrera_alumno",fetch= FetchType.LAZY)
    @JsonBackReference
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
