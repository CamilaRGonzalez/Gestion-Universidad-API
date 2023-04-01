package com.proyecto.api;

import com.proyecto.api.model.Materia;
import com.proyecto.api.service.IMateriaService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MateriasTest {
    @Autowired
    private IMateriaService service;
    
    @Test
    void getMaterias(){
        List<Materia> lista = service.getMaterias();
        
        for(var item:lista){
            System.out.println(item.toString());
        }
    }
    
      @Test
    void createMateria(){
        Materia materia = new Materia(0,"pepe I",1);
        service.saveMateria(materia, 1);       
    }
    
    @Test
    void editMateria(){
        Materia materia = new Materia(4,"pepe Iii",1);
        service.saveMateria(materia, 1);       
    }
    
    @Test
    void deleteMateria(){
        service.eliminarMateria(4);
    }
}
