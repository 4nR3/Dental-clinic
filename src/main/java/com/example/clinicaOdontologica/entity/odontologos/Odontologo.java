package com.example.clinicaOdontologica.entity.odontologos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOdontologo;
    private String nombre;
    private String apellido;
    private int matricula;

    public Odontologo(){}

    public Odontologo(int matricula, String nombre, String apellido){
        this.matricula=matricula;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + idOdontologo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
