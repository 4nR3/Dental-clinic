package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.clinica.Turnos;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.repository.clinica.ITurnosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnosService {

    private ITurnosRepository iTurnosRepository;

    public TurnosService(ITurnosRepository iTurnosRepository){
        this.iTurnosRepository = iTurnosRepository;
    }

    public List<Turnos> listaDeTurnos(){
        return iTurnosRepository.findAll();
    }

    public Turnos agregar(Turnos turno){
        return iTurnosRepository.save(turno);
    }

    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        if(iTurnosRepository.findById(id)==null)
            throw new ResourceNotFoundException("No se encontro ninguna pelicula con el id: "+id);
        iTurnosRepository.deleteById(id);
    }

    public Turnos buscarPorId(Long id){
        return iTurnosRepository.findById(id).get();
    }


}
