package com.proyecto.api.DTO;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoDTO {
    private Long id_alumno;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nac;

    @Override
    public String toString() {
        return "AlumnoDTO{" + "id_alumno=" + id_alumno + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_nac=" + fecha_nac + '}';
    }
    
}
