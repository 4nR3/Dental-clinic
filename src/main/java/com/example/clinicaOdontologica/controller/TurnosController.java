package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.dto.clinicaDto.TurnoDTO;
import com.example.clinicaOdontologica.entity.clinica.Turnos;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.OdontologoService;
import com.example.clinicaOdontologica.service.PacienteService;
import com.example.clinicaOdontologica.service.TurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnosController {

    @Autowired
    private TurnosService turnoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Turnos> listarTurnos() {
        return turnoService.listaDeTurnos();
    }

    @GetMapping("/{id}")
    public Turnos buscarTurnoPorId(@PathVariable("id") Long id) {
        return turnoService.buscarPorId(id);
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Turnos registrarOdontologo(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException {

        Turnos turno = new Turnos(
                odontologoService.buscarPorId(turnoDTO.getOdontologoId()).get(),
                pacienteService.buscarPorId(turnoDTO.getPacienteId()),
                turnoDTO.getFecha());

        return turnoService.agregar(turno);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity eliminarOdontologo(@PathVariable("id") Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("Turno eliminada correctamente");
    }


}
