package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.entity.pacientes.Domicilio;
import com.example.clinicaOdontologica.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;


    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Domicilio> listarDomicilios(){
        return domicilioService.listarDomicilios();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Optional<Domicilio> buscarDomicilioId(@PathVariable("id") Long id) {
        return domicilioService.buscarPorId(id);
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Domicilio registrarDomicilio(@RequestBody Domicilio domicilio){
        return domicilioService.guardarDomicilio(domicilio);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void eliminarDomicilio(@PathVariable("id") Long id){
        domicilioService.borrarPorId(id);
    }


}
