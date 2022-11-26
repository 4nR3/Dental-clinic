package com.example.clinicaOdontologica.entity.pacientes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "DOMICILIO")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDomicilio;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    public Domicilio(){}

    public Domicilio(String calle, int numero, String localidad, String provincia){
        this.calle=calle;
        this.numero=numero;
        this.localidad=localidad;
        this.provincia=provincia;

    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "idDomicilio=" + idDomicilio +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
