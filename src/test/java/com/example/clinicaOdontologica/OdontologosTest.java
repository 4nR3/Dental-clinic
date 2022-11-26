package com.example.clinicaOdontologica;

import com.example.clinicaOdontologica.entity.odontologos.Odontologo;
import com.example.clinicaOdontologica.service.OdontologoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OdontologosTest {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void cargarOdontologos(){
        try{
            Odontologo odontologo1 = odontologoService.registrarOdontologo(new Odontologo(123,"Sarah","Alfonsin"));
            Odontologo odontologo2 = odontologoService.registrarOdontologo(new Odontologo(111,"Grego","Martinez"));
            Odontologo odontologo3 = odontologoService.registrarOdontologo(new Odontologo(234,"Zoe","Tira"));
            Odontologo odontologo4 = odontologoService.registrarOdontologo(new Odontologo(567,"Salo","Morales"));
            Odontologo odontologo5 = odontologoService.registrarOdontologo(new Odontologo(890,"Sabrina","Garcia"));
            logger.info("Odontologos cargados con exito");
        }
        catch (Exception e){
            logger.error(e);
            logger.error("Hubo un error al cargar los datos");
        }

    }

    @Test
    @Order(2)
    public void ListarOdontologos(){
        List<Odontologo> listaOdontologos = odontologoService.listarOdontologos();
        Assertions.assertEquals(true, listaOdontologos.isEmpty() == false , "La lista de pacientes esta vacia");

        logger.info("\n --------------El listado de odontologos -------------- \n");

        for(Odontologo odontologo : listaOdontologos)
            logger.info(odontologo);
    }

}
