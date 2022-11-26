package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.entity.pacientes.Domicilio;
import com.example.clinicaOdontologica.entity.pacientes.Paciente;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Paciente> listarPaciente() {
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity <Paciente> buscarPacienteId(@PathVariable("id") Long id) throws ResourceNotFoundException{
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity <Paciente> registrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.registrarPaciente(paciente));
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity eliminarPaciente(@PathVariable("id") Long id) throws ResourceNotFoundException {
        pacienteService.borrarPorId(id);
        return ResponseEntity.ok("Paciente borrado con exito");
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity <Paciente> actualizarPaciente(@PathVariable("id")Long id, @RequestBody Paciente paciente) throws ResourceNotFoundException{
        return ResponseEntity.ok(pacienteService.actualizarPaciente(id,paciente));
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> mostrarSoloError(ResourceNotFoundException error){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
    }

}
