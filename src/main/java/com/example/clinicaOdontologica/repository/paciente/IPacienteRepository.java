package com.example.clinicaOdontologica.repository.paciente;

import com.example.clinicaOdontologica.entity.pacientes.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente,Long> {

}
