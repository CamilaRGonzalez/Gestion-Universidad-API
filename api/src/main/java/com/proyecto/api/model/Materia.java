package com.proyecto.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_materia;
    private String nombre;
    private Integer anio;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="fk_carrera", referencedColumnName="id_carrera")
    private Carrera carrera_materia;
    
    @ManyToMany(mappedBy = "listaMateriasAlumno")
    @JsonIgnore
    private List<Alumno> books;

    public Materia() {
    }

    public Materia(Integer id_materia, String nombre, Integer anio) {
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.anio = anio;
    }
    
    
    @Override
    public String toString() {
        return "Materia{" + "id_materia=" + id_materia + ", nombre=" + nombre + ", anio=" + anio + ", carrera_materia=" + carrera_materia + ", books=" + books + '}';
    }
    
    
}
