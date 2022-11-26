package com.example.clinicaOdontologica.entity.clinica;

import com.example.clinicaOdontologica.entity.odontologos.Odontologo;
import com.example.clinicaOdontologica.entity.pacientes.Paciente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Turnos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeTurno;

    @ManyToOne
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    private Date fechaTurno;


    public Turnos(){}

    public Turnos(Odontologo odontologo, Paciente paciente, Date fechaTurno) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaTurno = fechaTurno;
    }

    @Override
    public String toString() {
        return "Turnos{" +
                "idDeTurno=" + idDeTurno +
                ", odontologo=" + odontologo +
                ", paciente=" + paciente +
                ", fechaTurno=" + fechaTurno +
                '}';
    }
}
