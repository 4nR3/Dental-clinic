package com.example.clinicaOdontologica.dto.odontologoDto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class OdontologoDTO {

    private String nombre;
    private String apellido;

    public OdontologoDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public OdontologoDTO(){}

    @Override
    public String toString() {
        return "OdontologoDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
