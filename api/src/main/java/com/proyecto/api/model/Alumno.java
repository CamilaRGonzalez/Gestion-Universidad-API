package com.proyecto.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_alumno;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nac;
    
    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name="fk_carrera", referencedColumnName="id_carrera")
    @JsonManagedReference
    private Carrera carrera_alumno;
    
    //@JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE})
    @JoinTable(
        name = "alumnos_materias",
        joinColumns = @JoinColumn(name = "fk_alumno", nullable = false),
        inverseJoinColumns = @JoinColumn(name="fk_materia", nullable = false)
    )
    @JsonManagedReference
    private List<Materia> listaMateriasAlumno;

    public Alumno() {
    }

    public Alumno(Long id_alumno, String nombre, String apellido, LocalDate fecha_nac) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id_alumno=" + id_alumno + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_nac=" + fecha_nac + ", carrera_alumno=" + carrera_alumno + ", listaMateriasAlumno=" + listaMateriasAlumno + '}';
    }
    
    
    
}
