package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.repository.odontologo.IOdontologoRepository;
import com.example.clinicaOdontologica.dto.odontologoDto.OdontologoDTO;
import com.example.clinicaOdontologica.entity.odontologos.Odontologo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService{

    private IOdontologoRepository iOdontologoRepository;

    public OdontologoService(IOdontologoRepository iOdontologoRepository){
        this.iOdontologoRepository = iOdontologoRepository;
    }

    public Odontologo dtoAEntity(OdontologoDTO odontologoDTO){
        ObjectMapper mapper = new ObjectMapper();
        Odontologo odontologo=mapper.convertValue(odontologoDTO,Odontologo.class);
        return odontologo;
    }

    public OdontologoDTO entityADto(Odontologo odontologo){
        ObjectMapper mapper = new ObjectMapper();
        OdontologoDTO odontologoDTO=mapper.convertValue(odontologo,OdontologoDTO.class);
        return odontologoDTO;
    }

    public List<Odontologo> listarOdontologos() {
        return iOdontologoRepository.findAll();
    }

    public Optional <Odontologo> buscarPorId(Long aLong) throws ResourceNotFoundException{
        if(iOdontologoRepository.findById(aLong)==null)
            throw new ResourceNotFoundException("No se encontro ningun odontologo con id: "+aLong);
        return iOdontologoRepository.findById(aLong);
    }

    public void borrarPorId(Long aLong) throws ResourceNotFoundException {
        if(iOdontologoRepository.findById(aLong)==null)
            throw new ResourceNotFoundException("No se encontro ningun odontologo con id: "+aLong);
        iOdontologoRepository.deleteById(aLong);
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return iOdontologoRepository.save(odontologo);
    }

    public Odontologo actualizarOdontologo(Long id,Odontologo odontologo){
        odontologo.setIdOdontologo(id);
        return iOdontologoRepository.save(odontologo);
    }

}
