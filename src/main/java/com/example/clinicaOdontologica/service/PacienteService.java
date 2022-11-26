package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.repository.paciente.IPacienteRepository;
import com.example.clinicaOdontologica.dto.pacienteDto.PacienteDTO;
import com.example.clinicaOdontologica.entity.pacientes.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PacienteService{

    @Autowired
    private IPacienteRepository iPacienteRepository;

    public Paciente dtoAEntity(PacienteDTO pacienteDTO){
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente=mapper.convertValue(pacienteDTO,Paciente.class);
        return paciente;
    }

    public PacienteDTO entityADto(Paciente paciente){
        ObjectMapper mapper = new ObjectMapper();
        PacienteDTO pacienteDTO=mapper.convertValue(paciente,PacienteDTO.class);
        return pacienteDTO;
    }


    public List<Paciente> listarPacientes() {
        return iPacienteRepository.findAll();
    }

    public void borrarPorId(Long aLong) throws ResourceNotFoundException {
        if(buscarPorId(aLong)==null)
            throw new ResourceNotFoundException("No se encontro un paciente con id: "+aLong);

        iPacienteRepository.deleteById(aLong);
    }

    public Paciente registrarPaciente(Paciente paciente){

        paciente.setFechaDeIngreso(new Date());

        return iPacienteRepository.save(paciente);
    }

    public Paciente buscarPorId(Long aLong) throws  ResourceNotFoundException{
        if(iPacienteRepository.findById(aLong)==null)
            {throw new ResourceNotFoundException("No se encontro un paciente con id: "+aLong);}
        return iPacienteRepository.findById(aLong).get();
    }

    public Paciente actualizarPaciente(Long id, Paciente paciente){
        paciente.setIdPaciente(id);
        return iPacienteRepository.save(paciente);
    }


}
