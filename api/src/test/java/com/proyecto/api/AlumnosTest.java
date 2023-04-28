package com.proyecto.api;

import com.proyecto.api.model.Materia;
import com.proyecto.api.service.IAlumnoService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlumnosTest {
    @Autowired
    private IAlumnoService service;
    
    @Test
    void materiasPorAlumno(){
        List<Materia> materias = service.materiasPorAlumno(1);
        for(Materia mat: materias){
            System.out.println(mat.toString());
        }
        
    }
}
