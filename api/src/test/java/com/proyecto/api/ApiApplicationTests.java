package com.proyecto.api;

import com.proyecto.api.DTO.CarreraDTO;
import com.proyecto.api.DTO.CarreraMateriasDTO;
import com.proyecto.api.model.Carrera;
import com.proyecto.api.repository.ICarreraRepository;
import com.proyecto.api.service.ICarreraService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {
        @Autowired
        private ICarreraService service;
        
        @Autowired
        private ICarreraRepository repo;
        
	@Test
	void contextLoads() {
	}
        
        @Test
        void getCarreras(){
            List<CarreraDTO> lista = service.getCarreras();
            
            for(var item:lista){
                System.out.println(item.toString());
            }
        }
        
        @Test
        void getCarreraMaterias(){
            CarreraMateriasDTO dto = service.getMaterias(1);
            System.out.println(dto.toString());
        }
        
        @Test
        void saveCarrera(){
            Carrera carrera = new Carrera(0,"Glalala",4);
            boolean exito = service.saveCarrera(carrera);
            if(exito)
                System.out.println("exito");
            else
                System.out.println("no se pudo crear/editar");
        }
        
        @Test
        void deleteCarrera(){
            boolean exito = service.deleteCarrera(3);
            if(exito)
                System.out.println("exito");
            else
                System.out.println("no se pudo crear/editar");
        }

}
