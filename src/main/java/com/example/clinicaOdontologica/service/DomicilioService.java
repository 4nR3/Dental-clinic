package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.pacientes.Domicilio;
import com.example.clinicaOdontologica.repository.paciente.IDomicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DomicilioService{

    private IDomicilio iDomicilio;

    private DomicilioService(IDomicilio iDomicilio){
        this.iDomicilio=iDomicilio;
    }

    public List<Domicilio> listarDomicilios() {
        return iDomicilio.findAll();
    }

    public void borrarPorId(Long aLong) {
        iDomicilio.deleteById(aLong);
    }

    public Domicilio guardarDomicilio(Domicilio domicilio) {
        return iDomicilio.save(domicilio);
    }

    public Optional<Domicilio> buscarPorId(Long aLong) {
        return iDomicilio.findById(aLong);
    }

}
