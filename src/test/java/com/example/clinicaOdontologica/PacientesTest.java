package com.example.clinicaOdontologica;

import com.example.clinicaOdontologica.entity.pacientes.Domicilio;
import com.example.clinicaOdontologica.entity.pacientes.Paciente;
import com.example.clinicaOdontologica.service.DomicilioService;
import com.example.clinicaOdontologica.service.PacienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PacientesTest {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private DomicilioService domicilioService;

    @Test
    @Order(1)
    public void cargarPacientes(){
        try{
            Domicilio domicilio1 = domicilioService.guardarDomicilio(new Domicilio("Malvinas",2004,"Merlo","Buenos Aires"));
            Paciente paciente1 = pacienteService.registrarPaciente(new Paciente("Alvarez","Andre",123,new Date(),domicilio1));

            Domicilio domicilio2 = domicilioService.guardarDomicilio(new Domicilio("Congo",1234,"San Isidro","Buenos Aires"));
            Paciente paciente2 = pacienteService.registrarPaciente(new Paciente("Feijoo","Pedro",234,new Date(),domicilio2));

            Domicilio domicilio3 = domicilioService.guardarDomicilio(new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires"));
            Paciente paciente3 = pacienteService.registrarPaciente(new Paciente("Bauman","Peter",456,new Date(),domicilio3));

            Domicilio domicilio4 = domicilioService.guardarDomicilio(new Domicilio("Don Quijote",4114,"Madrid","España"));
            Paciente paciente4 = pacienteService.registrarPaciente(new Paciente("Garcia","Ana",678,new Date(),domicilio4));

            Domicilio domicilio5 = domicilioService.guardarDomicilio(new Domicilio("Av Corrientes",10500,"Puebla","Caracas"));
            Paciente paciente5 = pacienteService.registrarPaciente(new Paciente("Alcaraz","Felicia",890,new Date(),domicilio5));



            logger.info("Pacientes cargados con exito");
        }
        catch (Exception e){
            logger.error(e);
            logger.error("Hubo un error al cargar los datos");
        }

    }


    @Test
    @Order(2)
    public void ListarPacientes(){
        List<Paciente> listaPacientes = pacienteService.listarPacientes();
        Assertions.assertEquals(false, listaPacientes.isEmpty()==true, "La lista de pacientes esta vacia");

        logger.info("\n --------------El listado de pacientes-------------- \n");

        for(Paciente paciente : listaPacientes)
            logger.info(paciente);
    }

    @Test
    @Order(3)
    public void ListarDomicilios(){
        List<Domicilio> listaDomicilios = domicilioService.listarDomicilios();
        Assertions.assertEquals(true, listaDomicilios.isEmpty() , "La lista de domicilios esta vacia");

        logger.info("\n --------------El listado de domicilios-------------- \n");

        for(Domicilio domicilio : listaDomicilios)
            logger.info(domicilio);
    }


}
