package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.entity.odontologos.Odontologo;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List <Odontologo> listarOdontologos() {
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity <Optional <Odontologo> >buscarOdontologoId(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity <Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity eliminarOdontologo(@PathVariable("id") Long id) throws ResourceNotFoundException{
        odontologoService.borrarPorId(id);
        return ResponseEntity.ok("Odontologo borrado correctamente");
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  ResponseEntity <Odontologo> actualizarOdontologo(@PathVariable("id") Long id, @RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.actualizarOdontologo(id, odontologo));
    }

}
