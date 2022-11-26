package com.example.clinicaOdontologica.entity.pacientes;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private String apellido;
    private String nombre;
    private int dni;
    private Date fechaDeIngreso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id",referencedColumnName = "idDomicilio")
    private Domicilio domicilio;

    public Paciente(){}

    public Paciente(String apellido, String nombre, int dni, Date fechaDeIngreso,Domicilio domicilio){
        this.apellido=apellido;
        this.nombre=nombre;
        this.dni=dni;
        this.fechaDeIngreso=fechaDeIngreso;
        this.domicilio=domicilio;
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", fechaDeIngreso=" + fechaDeIngreso +
                ", domicilio=" + domicilio +
                '}';
    }
}
