package com.example.clinicaOdontologica;

import com.example.clinicaOdontologica.dto.odontologoDto.OdontologoDTO;
import com.example.clinicaOdontologica.dto.pacienteDto.PacienteDTO;
import com.example.clinicaOdontologica.entity.odontologos.Odontologo;
import com.example.clinicaOdontologica.entity.pacientes.Domicilio;
import com.example.clinicaOdontologica.entity.pacientes.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DtoTest {

    @Test
    public void testDto(){

        Domicilio domicilio = new Domicilio("Malvinas",2004,"Merlo","Buenos Aires");
        Paciente paciente = new Paciente("Alvarez","Andre",123,new Date(),domicilio);
        System.out.println(paciente.toString());
        ObjectMapper mapper = new ObjectMapper();
        PacienteDTO pacienteDTO=mapper.convertValue(paciente,PacienteDTO.class);
        pacienteDTO.setDireccion(domicilio.getCalle(),domicilio.getNumero());
        System.out.println(pacienteDTO.toString());
        Assert.assertNotNull(pacienteDTO);

    }
}
